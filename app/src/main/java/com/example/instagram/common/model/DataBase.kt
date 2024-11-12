package com.example.instagram.common.model

import java.util.UUID

object DataBase {

    val userAuth = hashSetOf<UserAuth>()
    var sessionAuth : UserAuth? = null

    init {
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "anabia@gmail.com", "12345678"))
        userAuth.add(UserAuth(UUID.randomUUID().toString(), "krisalpino@gmail.com", "87654321"))

    }
}