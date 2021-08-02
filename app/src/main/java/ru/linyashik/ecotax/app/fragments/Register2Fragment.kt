package ru.linyashik.ecotax.app.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.activity.loginSignup.AuthenticationMain
import ru.linyashik.ecotax.databinding.ActivityRegister2FragmentBinding


class Register2Fragment: Fragment() {

    //Variables
    private var binding: ActivityRegister2FragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityRegister2FragmentBinding.inflate(layoutInflater)
        val view = binding?.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Open Login Fragment
        binding?.signupLoginBtn?.setOnClickListener {
            (activity as AuthenticationMain).navController.navigate(R.id.action_register2Fragment_to_loginFragment)
        }
        //Open Register2 Fragment
        binding?.signupNextBtn?.setOnClickListener {
            (activity as AuthenticationMain).navController.navigate(R.id.action_register2Fragment_to_register3Fragment)
        }
        //Open Register Fragment
        binding?.signupBackButton?.setOnClickListener {
            (activity as AuthenticationMain).navController.navigate(R.id.action_register2Fragment_to_registerFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}