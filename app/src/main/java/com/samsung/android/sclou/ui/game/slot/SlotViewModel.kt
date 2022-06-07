package com.samsung.android.sclou.ui.game.slot

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samsung.android.sclou.data.model.QuennSlotModel
import com.samsung.android.sclou.data.model.ResultModel
import com.samsung.android.sclou.data.source.local.repo.ResultsRepositoryImpl
import com.samsung.android.sclou.data.source.local.repo.ScoreRepositoryImpl
import com.samsung.android.sclou.di.module.IODispatcher
import com.samsung.android.sclou.utils.game.SLOT_BOARD_MATCHED_FOR_WIN
import com.samsung.android.sclou.utils.game.SLOT_VIEW_VALUE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SlotViewModel @Inject constructor(
    private val scoreRepositoryImpl: ScoreRepositoryImpl,
    private val resultRepositoryImpl: ResultsRepositoryImpl,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    private var mapOfSlots = mutableStateMapOf<Int, List<QuennSlotModel>>()

    val score = scoreRepositoryImpl.getScore()
    var matchedSlots by mutableStateOf(0)

    var isRoll by mutableStateOf(false)

    fun saveSlots(columnId: Int, listOfSlots: List<QuennSlotModel>) {
        isRoll = false
        mapOfSlots.remove(columnId)
        mapOfSlots[columnId] = listOfSlots
        if (columnId == 5) processMatch()
    }

    private fun processMatch() {
        if (matchedSlots >= SLOT_BOARD_MATCHED_FOR_WIN) {
            viewModelScope.launch(ioDispatcher) {
                scoreRepositoryImpl.saveScore(0)
            }
        }
        matchedSlots = 0
        mapOfSlots.keys.forEach { currentList ->
            mapOfSlots[currentList]?.forEach { currentSlot ->

                mapOfSlots.keys.forEach { checkList ->
                    mapOfSlots[checkList]?.forEach { checkSlot ->
                        if (currentSlot.column < checkSlot.column &&
                            currentSlot.row == checkSlot.row &&
                            currentSlot.drawableRes == checkSlot.drawableRes
                        ) {
                            currentSlot.isMatched = true
                            checkSlot.isMatched = true
                            matchedSlots++
                        }
                    }
                }
            }
        }

        viewModelScope.launch(ioDispatcher) {
            when {
                matchedSlots < 5 && matchedSlots != 0 -> updateScore(matchedSlots)
                matchedSlots >= SLOT_BOARD_MATCHED_FOR_WIN -> saveResult(
                    score.first().score,
                    matchedSlots
                )
            }
        }
    }

    fun rollSlots() {
        if (!isRoll) {
            isRoll = true
        }
    }

    private suspend fun updateScore(matched: Int) {
        val currentScore = score.firstOrNull()?.score ?: 0
        val newScore = matched * SLOT_VIEW_VALUE + currentScore
        scoreRepositoryImpl.saveScore(newScore)
    }

    private suspend fun saveResult(score: Int, matched: Int) {
        resultRepositoryImpl.saveResult(
            ResultModel(
                resultScore = matched * SLOT_VIEW_VALUE + score,
                matched = matched
            )
        )
    }
}