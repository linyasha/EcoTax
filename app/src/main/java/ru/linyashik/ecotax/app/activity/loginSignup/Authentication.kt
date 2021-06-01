package ru.linyashik.ecotax.app.activity.loginSignup

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.view.View
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.activity.loginSignup.register.Register
import ru.linyashik.ecotax.databinding.ActivityAuthenticationBinding

class Authentication : AppCompatActivity() {
    //Variables
    private lateinit var binding: ActivityAuthenticationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Hooks
        binding.signInBtn.setOnClickListener {
            openWithAnimation(Login(),findViewById<View>(R.id.sign_in_btn), "transition_login")
        }
        binding.signUpBtn.setOnClickListener {
            openWithAnimation(Register(),findViewById<View>(R.id.sign_up_btn), "transition_register")
        }
    }

    private fun openWithAnimation(classToOpen: AppCompatActivity, view: View, transitionKey: String) {
        val intent = Intent(this, classToOpen::class.java)
        //Open activity with animation
        @SuppressLint("ObsoleteSdkInt")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val pairs = Pair(view, transitionKey)
            val options = ActivityOptions.makeSceneTransitionAnimation(this, pairs)
            startActivity(intent, options.toBundle())
        } else {
            startActivity(intent)
        }
    }
}