package com.example.instagram.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.databinding.FragmentRegisterEmailBinding
import com.example.instagram.databinding.FragmentRegisterNamePasswordBinding
import com.example.instagram.login.view.LoginActivity

class RegisterNamePassword : Fragment() {

    private var binding : FragmentRegisterNamePasswordBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_name_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)

        binding?.let {
            with(it) {
                buttonEntrarRegister.setOnClickListener {
                    navigateToRegisterPhoto()
                }
            }
        }
    }

    private fun navigateToRegisterPhoto() {
        val registerPhotoFragment = RegisterPhoto()

        parentFragmentManager.beginTransaction().apply {
            replace(R.id.registerFragment,registerPhotoFragment)
            addToBackStack(null)
            commit()
        }
    }
}