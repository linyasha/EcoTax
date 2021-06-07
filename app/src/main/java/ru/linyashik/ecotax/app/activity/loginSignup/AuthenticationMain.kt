package ru.linyashik.ecotax.app.activity.loginSignup

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.databinding.ActivityAuthenticationMainBinding

class AuthenticationMain : AppCompatActivity(), LoginFragment.ActionPerformedListenerLoginFragment,
RegisterFragment.ActionPerformedListenerRegisterFragment,
    Register2Fragment.ActionPerformedListenerRegister2Fragment {

    private lateinit var binding: ActivityAuthenticationMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationMainBinding.inflate(layoutInflater)
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
        openLoginFragment()
    }
    private fun openLoginFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, LoginFragment())
            .commit()
    }

    override fun actionClickLoginBtn() {

    }

    override fun actionClickRegisterBtn() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment,
                R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment)
            .addToBackStack(null)
            .replace(R.id.container, Register2Fragment())
            .commit()
    }

    override fun actionClickNewUserBtn() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment,
            R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment)
            .replace(R.id.container, RegisterFragment())
            .commit()
    }

    override fun actionClickHaveAccount() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment,
                R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment)
            .replace(R.id.container, LoginFragment())
            .commit()
    }

    override fun actionClickNextBtn() {
        TODO("Not yet implemented")
    }

    override fun actionClickLoginRegister2Fragment() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment,
                R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment)
            .replace(R.id.container, LoginFragment())
            .commit()
    }

    override fun actionClickBackRegister2Fragment() {

    }


}