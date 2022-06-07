package com.samsung.android.sclou

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import com.samsung.android.sclou.utils.game.randomDecalId

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val screenHeight = resources.configuration.screenHeightDp

        val ivBg = findViewById<ImageView>(R.id.iv_bg)
        val tvAppName = findViewById<TextView>(R.id.tv_app_name)


        val clDecalsParent = findViewById<ConstraintLayout>(R.id.cl_decals_parent)
        val ivDecal1 = findViewById<ImageView>(R.id.iv_decal_1)
        val ivDecal2 = findViewById<ImageView>(R.id.iv_decal_2)
        val ivDecal3 = findViewById<ImageView>(R.id.iv_decal_3)


        val tvNameAlpha = ObjectAnimator.ofFloat(tvAppName, View.ALPHA, 0F, 1F).apply {
            duration = 1100
        }
        val ivBgInAlpha = ObjectAnimator.ofFloat(ivBg, View.ALPHA, 0F, 1F).apply {
            duration = 500
        }
        val ivBgOutAlpha = ObjectAnimator.ofFloat(ivBg, View.ALPHA, 1F, 0.2F).apply {
            duration = 800
        }


        val parentDecalsAlpha = ObjectAnimator.ofFloat(clDecalsParent, View.ALPHA, 1F, 0.2F).apply {
            duration = 800
        }
        val parentDecalsScaleX =
            ObjectAnimator.ofFloat(clDecalsParent, View.SCALE_X, 2F, 1F).apply {
                duration = 1500
            }
        val parentDecalsScaleY =
            ObjectAnimator.ofFloat(clDecalsParent, View.SCALE_Y, 2F, 1F).apply {
                duration = 1500
            }

        AnimatorSet().apply {
            play(ivBgInAlpha)
                .with(parentDecalsScaleX).with(parentDecalsScaleY)
                .with(createTranslationObjectAnimator(ivDecal1, screenHeight))
                .with(createTranslationObjectAnimator(ivDecal2, screenHeight))
                .with(createTranslationObjectAnimator(ivDecal3, screenHeight))
            doOnEnd {
                parentDecalsAlpha.start()
                ivBgOutAlpha.start()
                tvNameAlpha.apply {
                    doOnEnd {
                        navigateToMainActivity()
                    }
                    start()
                }
            }
            start()
        }
    }

    private fun createTranslationObjectAnimator(
        view: ImageView,
        screenHeight: Int,
        toInitial: Boolean = false
    ): ObjectAnimator {

        return ObjectAnimator.ofFloat(
            view,
            View.TRANSLATION_Y,
            screenHeight * 2F,
            if (toInitial) 0F else screenHeight * -2F,
        ).apply {
            duration = if (toInitial) 375 else 750
            doOnEnd {
                if (!toInitial) {
                    createTranslationObjectAnimator(view.apply {
                        setImageResource(randomDecalId)
                    }, screenHeight, toInitial = true).start()
                }
            }
        }
    }

    private fun navigateToMainActivity() {
        Intent(this, MainActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }
}