package ru.linyashik.ecotax.app.activity.loginSignup

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Pair
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.activity.loginSignup.register.Register
import ru.linyashik.ecotax.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    //Variables
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
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


        binding.createAccountBtn.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP )
            //Open activity with animation
            @SuppressLint("ObsoleteSdkInt")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val pairs: Array<Pair<View,String>> = arrayOf(
                    Pair(findViewById<View>(R.id.logo_login), "logo_image"),
                    Pair(findViewById<View>(R.id.logo_name), "logo_text"),
                    Pair(findViewById<View>(R.id.slogo_name), "logo_desc"),
                    Pair(findViewById<View>(R.id.edit_username), "username"),
                    Pair(findViewById<View>(R.id.edit_password), "password"),
                    Pair(findViewById<View>(R.id.login_btn), "login_btn"),
                    Pair(findViewById<View>(R.id.create_account_btn), "transition_login-btn"),
                )
                val options = ActivityOptions.makeSceneTransitionAnimation(this, pairs[0],pairs[1],pairs[2],
                    pairs[3],pairs[4],pairs[5],pairs[6])
                startActivity(intent, options.toBundle())
                //finish()
            } else {
                startActivity(intent)
                //finish()
            }

        }


    }

//    override fun onDestroy() {
//        Log.d("deg", "Hi")
//        super.onDestroy()
//    }

}