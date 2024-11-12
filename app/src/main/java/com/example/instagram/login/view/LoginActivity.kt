package com.example.instagram.login.view

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.R
import com.example.instagram.common.base.DependencyInjector
import com.example.instagram.databinding.ActivityLoginBinding
import com.example.instagram.home.Home
import com.example.instagram.login.Login
import com.example.instagram.login.data.FakeDataSource
import com.example.instagram.login.data.LoginRepository
import com.example.instagram.login.presentation.LoginPresenter

class LoginActivity : AppCompatActivity(), Login.View {

    private lateinit var binding : ActivityLoginBinding
    override lateinit var presenter : Login.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this, DependencyInjector.loginRepository() )


        with(binding) {
            binding.buttonEntrarLogin.setOnClickListener {
                presenter.login(inputEmailLogin.text.toString(), inputSenhaLogin.text.toString() )
            }
        }

        window.statusBarColor = getColor(R.color.white)

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun displayEmailFailure(emailError: Int?) {
        binding.inputEmailLogin.error = emailError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding.inputSenhaLogin.error = passwordError?.let { getString(it) }
    }

    override fun onUserAuthenticated() {
       startActivity(Intent(this, Home::class.java))
    }

    override fun onUserUnauthorized(message: String) {
       Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}