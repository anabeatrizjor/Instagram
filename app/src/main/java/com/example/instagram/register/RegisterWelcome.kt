package com.example.instagram.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instagram.MainActivity
import com.example.instagram.R
import com.example.instagram.common.CustomDialog
import com.example.instagram.databinding.FragmentRegisterPhotoBinding
import com.example.instagram.databinding.FragmentWelcomeBinding
import com.example.instagram.home.Home
import com.example.instagram.login.view.LoginActivity

class RegisterWelcome : Fragment() {

    private var binding: FragmentWelcomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val customDialog = CustomDialog(requireContext())

        binding = FragmentWelcomeBinding.bind(view)


        binding?.let {
            with(it) {
                buttonAcessarInsta.setOnClickListener {
                    startActivity(Intent(requireContext(), Home::class.java))
                    activity?.finish()
                }
            }
        }
    }
}