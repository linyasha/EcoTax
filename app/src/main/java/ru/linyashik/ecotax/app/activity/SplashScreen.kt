package ru.linyashik.ecotax.app.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.activity.loginSignup.Authentication
import ru.linyashik.ecotax.databinding.SplashActivityBinding

class SplashScreen : AppCompatActivity() {

    //Variables
    private lateinit var binding: SplashActivityBinding
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private lateinit var onBoardingScreen: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Set fullscreen
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        //Hooks
        binding.imageCar.animation = topAnim
        binding.nameApplication.animation = bottomAnim
        binding.logoApp.animation = bottomAnim

        //Transition to DashBoard activity
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            //Run OnBoarding once
            onBoardingScreen = getSharedPreferences("OnBoardingScreen", MODE_PRIVATE)
            val isFirstTime = onBoardingScreen.getBoolean("firstTimeRunApplication", true)
            if(isFirstTime) {
                val editor = onBoardingScreen.edit()
                editor.putBoolean("firstTimeRunApplication", false)
                editor.apply()
                val intent = Intent(this, OnBoarding::class.java)
                startActivity(intent)
                finish()
            }
            else {
                val intent = Intent(this, Authentication::class.java)
                startActivity(intent)
                finish()
            }
            }, SPLASH_SCREEN.toLong())
    }

    companion object{
        private const val firstTimeRunApplication = "firstTimeRun"
        private val SPLASH_SCREEN = 3000
    }
}