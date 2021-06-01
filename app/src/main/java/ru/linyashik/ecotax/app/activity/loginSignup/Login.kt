package ru.linyashik.ecotax.app.activity.loginSignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.linyashik.ecotax.databinding.ActivityAuthenticationBinding
import ru.linyashik.ecotax.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    //Variables
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}