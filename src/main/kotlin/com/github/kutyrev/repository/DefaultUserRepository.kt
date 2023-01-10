package com.github.kutyrev.repository

import com.github.kutyrev.service.CreateUserParams
import com.github.kutyrev.service.UserService
import com.github.kutyrev.utils.BaseResponse

class DefaultUserRepository(private val userService: UserService) : UserRepository {
    override suspend fun registerUser(params: CreateUserParams): BaseResponse<Any> {
       return if(isLoginExist(params.login)) {
           BaseResponse.ErrorResponse("Login already exist")
       } else {
           val user = userService.registerUser(params)
           if (user != null){
               BaseResponse.SuccessResponse(data = user)
           }else {
               BaseResponse.ErrorResponse()
           }
       }
    }

    override suspend fun login(login: String, password: String): BaseResponse<Any> {
        TODO("Not yet implemented")
    }

    private suspend fun isLoginExist(login: String): Boolean {
        return userService.getUser(login) != null
    }
}
