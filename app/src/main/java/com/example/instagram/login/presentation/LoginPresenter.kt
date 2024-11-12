package com.example.instagram.login.presentation

import android.util.Patterns
import com.example.instagram.R
import com.example.instagram.common.model.UserAuth
import com.example.instagram.login.Login
import com.example.instagram.login.data.LoginCallback
import com.example.instagram.login.data.LoginRepository

class LoginPresenter( private var view : Login.View?, private val repository: LoginRepository) : Login.Presenter {

    override fun login(email: String, password: String) {

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 8

        if (!isEmailValid){
            view?.displayEmailFailure(R.string.error)
        }else{
            view?.displayEmailFailure(null)
        }

        if (!isPasswordValid) {
            view?.displayPasswordFailure(R.string.error)
        }else{
            view?.displayPasswordFailure(null)
        }

        if (isEmailValid && isPasswordValid) {
            repository.login(email, password, object : LoginCallback{
                override fun onSuccess(userAuth: UserAuth) {
                  view?.onUserAuthenticated()
                }

                override fun onFailure(message: String) {
                    view?.onUserUnauthorized(message)
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

            })
        }
    }

    override fun onDestroy() {
        view = null
    }
}