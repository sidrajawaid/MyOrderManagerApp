package com.example.myordermanager.activities


import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.myordermanager.NavigationRoute.Route
import com.example.myordermanager.ViewModel.MainviewModel
import com.example.myordermanager.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {


    private val mainVieModel by viewModels<MainviewModel>()
  // private val viewModel = ViewModelProvider(this).get(SheduleViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !mainVieModel.isReady.value
            }

            setOnExitAnimationListener { screen ->
                val zoomx = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f, 0.0f
                )
                zoomx.interpolator = OvershootInterpolator()
                zoomx.duration = 800
                zoomx.doOnEnd {
                    screen.remove()
                }

                val zoomy = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f, 0.0f
                )
                zoomy.interpolator = OvershootInterpolator()
                zoomy.duration = 800
                zoomy.doOnEnd {
                    screen.remove()
                }

                zoomx.start()
                zoomy.start()
            }
        }

        setContent() {
            AppTheme {
             Route()
            }

        }

    }
}