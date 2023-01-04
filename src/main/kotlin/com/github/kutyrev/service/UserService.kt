package com.github.kutyrev.service

import com.github.kutyrev.models.User

interface UserService {
    suspend fun registerUser(params: CreateUserParams): User?
}
