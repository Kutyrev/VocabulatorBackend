package com.github.kutyrev.repository

import com.github.kutyrev.service.CreateUserParams
import com.github.kutyrev.utils.BaseResponse

interface UserRepository {
    suspend fun registerUser(params: CreateUserParams): BaseResponse<Any>
    suspend fun login(login: String, password: String): BaseResponse<Any>
}
