package com.example.instagram.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.common.CustomDialog
import com.example.instagram.databinding.FragmentRegisterPhotoBinding

class RegisterPhoto : Fragment(R.layout.fragment_register_photo) {

    private var binding: FragmentRegisterPhotoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val customDialog = CustomDialog(requireContext())

        binding = FragmentRegisterPhotoBinding.bind(view)

        binding?.let {
            with(it) {
                buttonPularAddPhoto.setOnClickListener {
                    navigateToRegisterWelcome()
                }
            }
        }

        customDialog.addButton({
        }, R.string.photo, R.string.gallery)
        customDialog.show()
    }

    private fun navigateToRegisterWelcome() {
        val registerWelcomeFragment = RegisterNamePassword()

        parentFragmentManager.beginTransaction().apply {
            replace(R.id.registerFragment, RegisterWelcome())
            addToBackStack(null)
            commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
