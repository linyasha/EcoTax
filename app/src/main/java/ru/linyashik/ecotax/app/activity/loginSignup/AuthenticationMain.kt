package ru.linyashik.ecotax.app.activity.loginSignup

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.fragments.LoginFragment
import ru.linyashik.ecotax.app.fragments.Register2Fragment
import ru.linyashik.ecotax.app.fragments.Register3Fragment
import ru.linyashik.ecotax.app.fragments.RegisterFragment
import ru.linyashik.ecotax.databinding.ActivityAuthenticationMainBinding

class AuthenticationMain : AppCompatActivity() {

    private lateinit var binding: ActivityAuthenticationMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host)

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
    }

}