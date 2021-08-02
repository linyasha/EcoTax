package ru.linyashik.ecotax.app.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.activity.loginSignup.AuthenticationMain
import ru.linyashik.ecotax.databinding.ActivityLoginBinding

class LoginFragment: Fragment() {

    //Variables
    private var binding: ActivityLoginBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Send request to DB for Login
        binding?.loginBtn?.setOnClickListener {
            //TODO(Request to DB)
        }
        //Open Register Fragment
        binding?.createAccountBtn?.setOnClickListener {
            (activity as AuthenticationMain).navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}