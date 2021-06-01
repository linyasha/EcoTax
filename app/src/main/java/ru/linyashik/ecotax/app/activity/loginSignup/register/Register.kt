package ru.linyashik.ecotax.app.activity.loginSignup.register

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    //Variables
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupNextBtn.setOnClickListener {
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
    }
}