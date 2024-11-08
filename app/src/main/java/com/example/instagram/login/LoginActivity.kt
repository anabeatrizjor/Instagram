package com.example.instagram.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.instagram.R

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextEmail = findViewById<EditText>(R.id.inputEmailLogin)
        val editTextSenha = findViewById<EditText>(R.id.inputSenhaLogin)

        val buttonEnter = findViewById<Button>(R.id.buttonEntrarLogin)


        window.statusBarColor = getColor(R.color.white)

    }

}