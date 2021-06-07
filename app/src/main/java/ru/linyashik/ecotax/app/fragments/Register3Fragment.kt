package ru.linyashik.ecotax.app.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.linyashik.ecotax.app.activity.loginSignup.interfaces.ActionPerformedListenerRegister3Fragment
import ru.linyashik.ecotax.databinding.ActivityRegister2FragmentBinding
import ru.linyashik.ecotax.databinding.ActivityRegister3FragmentBinding

class Register3Fragment: Fragment() {

    //Variables
    private var listener: ActionPerformedListenerRegister3Fragment? = null
    private var binding: ActivityRegister3FragmentBinding? = null

    //Attach listener to MainActivity
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ActionPerformedListenerRegister3Fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityRegister3FragmentBinding.inflate(layoutInflater)
        val view = binding?.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.signupLoginBtn?.setOnClickListener {
            listener?.register3FragmentActionClickLoginBtn()
        }

        binding?.signupNextBtn?.setOnClickListener {
            listener?.register3FragmentActionClickNextBtn()
        }

        binding?.signupBackButton?.setOnClickListener {
            listener?.register3FragmentActionClickBackBtn()
        }
    }

}