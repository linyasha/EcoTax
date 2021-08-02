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
import ru.linyashik.ecotax.databinding.ActivityRegisterBinding

class RegisterFragment: Fragment() {

    //Variables
    //private var listener: ActionPerformedListenerRegisterFragment? = null
    private var binding: ActivityRegisterBinding? = null

    //Attach listener to MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        //listener = context as ActionPerformedListenerRegisterFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding?.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Open Login Fragment
        binding?.haveAccountBtn?.setOnClickListener {
            (activity as AuthenticationMain).navController.navigate(R.id.action_registerFragment_to_loginFragment)
        }
        //Open Register2 Fragment
        binding?.registerBtn?.setOnClickListener {
            (activity as AuthenticationMain).navController.navigate(R.id.action_registerFragment_to_register2Fragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}