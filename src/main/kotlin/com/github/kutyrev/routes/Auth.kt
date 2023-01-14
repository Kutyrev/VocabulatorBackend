package com.github.kutyrev.routes

import com.github.kutyrev.repository.UserRepository
import com.github.kutyrev.service.CreateUserParams
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.authRoutes(userRepository: UserRepository) {
    routing {
        route("/auth") {
            post("/register") {
                val params = call.receive<CreateUserParams>()
                val result = userRepository.registerUser(params)
                call.respond(result.statusCode, result)
            }
        }
    }
}
