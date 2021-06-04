package ru.linyashik.ecotax.app.activity.loginSignup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.linyashik.ecotax.databinding.ActivityLoginBinding
import ru.linyashik.ecotax.databinding.ActivityRegisterBinding

class RegisterFragment: Fragment() {
    //Communication with activity
    interface ActionPerformedListenerRegisterFragment {
        fun actionClickRegisterBtn()
        fun actionClickHaveAccount()
    }

    //Variables
    private var listener: ActionPerformedListenerRegisterFragment? = null
    private var binding: ActivityRegisterBinding? = null

    //Attach listener to MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ActionPerformedListenerRegisterFragment
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
        binding?.haveAccountBtn?.setOnClickListener {
          listener?.actionClickHaveAccount()
        }
//        binding?.loginBtn?.setOnClickListener {
//            listener?.actionClickLoginBtn()
//        }
//
//        binding?.createAccountBtn?.setOnClickListener {
//            listener?.actionClickNewUserBtn()
//        }
    }

}