package ru.linyashik.ecotax.app.activity.loginSignup

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.activity.loginSignup.interfaces.ActionPerformedListenerLoginFragment
import ru.linyashik.ecotax.app.activity.loginSignup.interfaces.ActionPerformedListenerRegister2Fragment
import ru.linyashik.ecotax.app.activity.loginSignup.interfaces.ActionPerformedListenerRegister3Fragment
import ru.linyashik.ecotax.app.activity.loginSignup.interfaces.ActionPerformedListenerRegisterFragment
import ru.linyashik.ecotax.app.fragments.LoginFragment
import ru.linyashik.ecotax.app.fragments.Register2Fragment
import ru.linyashik.ecotax.app.fragments.Register3Fragment
import ru.linyashik.ecotax.app.fragments.RegisterFragment
import ru.linyashik.ecotax.databinding.ActivityAuthenticationMainBinding

class AuthenticationMain : AppCompatActivity(), ActionPerformedListenerLoginFragment,
    ActionPerformedListenerRegisterFragment,
    ActionPerformedListenerRegister2Fragment,
    ActionPerformedListenerRegister3Fragment
{

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
            .replace(R.id.container, LoginFragment())
            .commit()
    }

    //Press Login button on the LoginFragment
    override fun loginFragmentActionClickLoginBtn() {
        //TODO("Add authentication logic ")
    }
    //Press New user button on the LoginFragment
    override fun loginFragmentActionClickNewUserBtn() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment,
                R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment)
            .replace(R.id.container, RegisterFragment())
            .commit()
    }

    //Press Register button on the RegisterFragment
    override fun registerFragmentActionClickRegisterBtn() {
        //TODO("Add check for valid values in fields and save state in fields")
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment,
                R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment)
            .addToBackStack(null)
            .replace(R.id.container, Register2Fragment())
            .commit()
    }


    //Press Have Account button on the RegisterFragment
    override fun registerFragmentActionClickHaveAccountBtn() {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment,
                R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment)
            .replace(R.id.container, LoginFragment())
            .commit()
    }

    //Press Next button on the Register2Fragment
    override fun register2FragmentActionClickNextBtn() {
        //TODO("Add check for valid values in fields and save state in fields")
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment,
                R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment)
            .addToBackStack(null)
            .replace(R.id.container, Register3Fragment())
            .commit()
    }

    //Press Login button on the Register2Fragment
    override fun register2FragmentActionClickLoginBtn() {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.enter_left_to_right_fragment, R.anim.exit_left_to_right_fragment,
                R.anim.enter_right_to_left_fragment, R.anim.exit_right_to_left_fragment)
            .replace(R.id.container, LoginFragment())
            .commit()

    }

    //Press Back button on the Register2Fragment
    override fun register2FragmentActionClickBackBtn() {
        onBackPressed()
    }

    //Press Next button on the Register3Fragment
    override fun register3FragmentActionClickNextBtn() {
        //TODO("Add authentication logic and check for valid values in fields")
    }

    //Press Back button on the Register3Fragment
    override fun register3FragmentActionClickBackBtn() {
        register2FragmentActionClickBackBtn()
    }

    //Press Login button on the Register3Fragment
    override fun register3FragmentActionClickLoginBtn() {
        supportFragmentManager.popBackStack()
        register2FragmentActionClickLoginBtn()
    }

}