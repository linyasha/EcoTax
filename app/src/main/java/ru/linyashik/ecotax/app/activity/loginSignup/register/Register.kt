package ru.linyashik.ecotax.app.activity.loginSignup.register

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.activity.loginSignup.Login
import ru.linyashik.ecotax.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    //Variables
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
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

        binding.registerNextBtn.setOnClickListener {
            val intent = Intent(this, Register2ndClass::class.java)
            //Open activity with animation
            @SuppressLint("ObsoleteSdkInt")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val pair1 = Pair(findViewById<View>(R.id.signup_back_button), "transition_back_arrow_btn")
                val pair2 = Pair(findViewById<View>(R.id.signup_login_btn), "transition_login-btn")
                val pair3 = Pair(findViewById<View>(R.id.signup_title_text), "transition_title_text")
                val pair4 = Pair(findViewById<View>(R.id.signup_next_btn), "transition_next_btn")
                val options = ActivityOptions.makeSceneTransitionAnimation(this, pair1, pair2, pair3, pair4)
                startActivity(intent, options.toBundle())
            } else {
                startActivity(intent)
            }
        }

        binding.registerLoginBtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP )
            //Open activity with animation
            @SuppressLint("ObsoleteSdkInt")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val pairs: Array<Pair<View,String>> = arrayOf(
                    Pair(findViewById<View>(R.id.logo_login), "logo_image"),
                    Pair(findViewById<View>(R.id.logo_name), "logo_text"),
                    Pair(findViewById<View>(R.id.slogo_name), "logo_desc"),
                    Pair(findViewById<View>(R.id.edit_username_reg), "username"),
                    Pair(findViewById<View>(R.id.edit_password_reg), "password"),
                    Pair(findViewById<View>(R.id.register_next_btn), "login_btn"),
                    Pair(findViewById<View>(R.id.register_login_btn), "transition_login-btn"),
                )
                val options = ActivityOptions.makeSceneTransitionAnimation(this, pairs[0],pairs[1],pairs[2],
                    pairs[3],pairs[4],pairs[5],pairs[6])
                startActivity(intent, options.toBundle())
                finish()
            } else {
                startActivity(intent)
                finish()
            }
        }


    }
}