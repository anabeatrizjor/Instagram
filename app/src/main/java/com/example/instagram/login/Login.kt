package com.example.instagram.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.common.base.BasePresenter
import com.example.instagram.common.base.BaseView

interface Login {

    interface Presenter : BasePresenter {
        fun login(email: String, password: String)

        fun onDestroy()
    }

    interface View : BaseView<Presenter> {
        fun displayEmailFailure(emailError: Int?)
        fun displayPasswordFailure(passwordError: Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message: String)
    }
}