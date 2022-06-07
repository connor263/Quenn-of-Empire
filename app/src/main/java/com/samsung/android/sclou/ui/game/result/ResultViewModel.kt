package com.samsung.android.sclou.ui.game.result

import androidx.lifecycle.ViewModel
import com.samsung.android.sclou.data.source.local.repo.ResultsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    resultsRepositoryImpl: ResultsRepositoryImpl
) : ViewModel() {
    val results = resultsRepositoryImpl.getResults()
}