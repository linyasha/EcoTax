package ru.linyashik.ecotax.app.activity.loginSignup

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.linyashik.ecotax.databinding.ActivityRegister2FragmentBinding


class Register2Fragment: Fragment() {

    //Communication with activity
    interface ActionPerformedListenerRegister2Fragment {
        fun actionClickNextBtn()
        fun actionClickLoginRegister2Fragment()
        fun actionClickBackRegister2Fragment()
    }

    //Variables
    private var listener: ActionPerformedListenerRegister2Fragment? = null
    private var binding: ActivityRegister2FragmentBinding? = null

    //Attach listener to MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ActionPerformedListenerRegister2Fragment
    }

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
        binding?.signupLoginBtn?.setOnClickListener {
            listener?.actionClickLoginRegister2Fragment()
        }

        binding?.signupNextBtn?.setOnClickListener {
            listener?.actionClickNextBtn()
        }

        binding?.signupBackButton?.setOnClickListener {
            listener?.actionClickBackRegister2Fragment()
        }
    }

}