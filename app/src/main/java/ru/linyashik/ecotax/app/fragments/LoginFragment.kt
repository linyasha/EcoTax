package ru.linyashik.ecotax.app.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.linyashik.ecotax.app.activity.loginSignup.interfaces.ActionPerformedListenerLoginFragment
import ru.linyashik.ecotax.databinding.ActivityLoginBinding

class LoginFragment: Fragment() {

    //Variables
    private var listener: ActionPerformedListenerLoginFragment? = null
    private var binding: ActivityLoginBinding? = null

    //Attach listener to MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ActionPerformedListenerLoginFragment
    }

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
        binding?.loginBtn?.setOnClickListener {
           listener?.loginFragmentActionClickLoginBtn()
        }

        binding?.createAccountBtn?.setOnClickListener {
            listener?.loginFragmentActionClickNewUserBtn()
        }
    }

}