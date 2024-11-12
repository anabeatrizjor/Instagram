package com.example.instagram.common.base

import com.example.instagram.login.data.FakeDataSource
import com.example.instagram.login.data.LoginCallback
import com.example.instagram.login.data.LoginDataSource
import com.example.instagram.login.data.LoginRepository

object DependencyInjector {

    fun loginRepository() : LoginRepository {
        return LoginRepository(FakeDataSource())
    }
}

