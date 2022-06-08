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
import com.samsung.android.sclou.utils.randomDecalId

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val scrbuelafmmcomsamsdght = resources.configuration.screenHeightDp

        val ibuelafmmcomsamsdg = findViewById<ImageView>(R.id.iv_bg)
        val tbuelafmmcomsamsdame = findViewById<TextView>(R.id.tv_app_name)


        val clbuelafmmcomsamsdsParent = findViewById<ConstraintLayout>(R.id.cl_decals_parent)
        val ivbuelafmmcomsamsdal1 = findViewById<ImageView>(R.id.iv_decal_1)
        val buelafmmcomsamsdecal2 = findViewById<ImageView>(R.id.iv_decal_2)
        val ivbuelafmmcomsamsdal3 = findViewById<ImageView>(R.id.iv_decal_3)


        val tvNabuelafmmcomsamsdAlpha = ObjectAnimator.ofFloat(tbuelafmmcomsamsdame, View.ALPHA, 0F, 1F).apply {
            duration = 1100
        }
        val ivBbuelafmmcomsamsdlpha = ObjectAnimator.ofFloat(ibuelafmmcomsamsdg, View.ALPHA, 0F, 1F).apply {
            duration = 500
        }
        val ivBbuelafmmcomsamsdAlpha = ObjectAnimator.ofFloat(ibuelafmmcomsamsdg, View.ALPHA, 1F, 0.2F).apply {
            duration = 800
        }


        val parebuelafmmcomsamsdalsAlpha = ObjectAnimator.ofFloat(clbuelafmmcomsamsdsParent, View.ALPHA, 1F, 0.2F).apply {
            duration = 800
        }
        val parenbuelafmmcomsamsdsScaleX =
            ObjectAnimator.ofFloat(clbuelafmmcomsamsdsParent, View.SCALE_X, 2F, 1F).apply {
                duration = 1500
            }
        val parentbuelafmmcomsamsdlsScaleY =
            ObjectAnimator.ofFloat(clbuelafmmcomsamsdsParent, View.SCALE_Y, 2F, 1F).apply {
                duration = 1500
            }

        AnimatorSet().apply {
            play(ivBbuelafmmcomsamsdlpha)
                .with(parenbuelafmmcomsamsdsScaleX).with(parentbuelafmmcomsamsdlsScaleY)
                .with(createTrbuelafmmcomsamsdAnimator(ivbuelafmmcomsamsdal1, scrbuelafmmcomsamsdght))
                .with(createTrbuelafmmcomsamsdAnimator(buelafmmcomsamsdecal2, scrbuelafmmcomsamsdght))
                .with(createTrbuelafmmcomsamsdAnimator(ivbuelafmmcomsamsdal3, scrbuelafmmcomsamsdght))
            doOnEnd {
                parebuelafmmcomsamsdalsAlpha.start()
                ivBbuelafmmcomsamsdAlpha.start()
                tvNabuelafmmcomsamsdAlpha.apply {
                    doOnEnd {
                        navbuelafmmcomsamsdivity()
                    }
                    start()
                }
            }
            start()
        }
    }

    private fun createTrbuelafmmcomsamsdAnimator(
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
                    createTrbuelafmmcomsamsdAnimator(view.apply {
                        setImageResource(randomDecalId)
                    }, screenHeight, toInitial = true).start()
                }
            }
        }
    }

    private fun navbuelafmmcomsamsdivity() {
        Intent(this, MainActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }
}