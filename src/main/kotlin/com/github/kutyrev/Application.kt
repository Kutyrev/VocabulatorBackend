package com.github.kutyrev

import com.github.kutyrev.database.DatabaseFactory
import com.github.kutyrev.repository.DefaultUserRepository
import com.github.kutyrev.routes.authRoutes
import com.github.kutyrev.service.DefaultUserService
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    install(ContentNegotiation) {
        jackson()
    }
    authRoutes(DefaultUserRepository(DefaultUserService()))
}
