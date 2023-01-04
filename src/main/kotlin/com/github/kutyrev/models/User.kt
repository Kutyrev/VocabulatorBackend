package com.github.kutyrev.models

data class User(val id: Int, val login: String, val password: String, var authToken: String? = null)