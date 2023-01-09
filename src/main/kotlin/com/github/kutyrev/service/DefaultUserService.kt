package com.github.kutyrev.service

import com.github.kutyrev.database.DatabaseFactory.dbQuery
import com.github.kutyrev.database.UserTable
import com.github.kutyrev.models.User
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.statements.InsertStatement

class DefaultUserService : UserService {
    override suspend fun registerUser(params: CreateUserParams): User? {
        var statement: InsertStatement<Number>? = null
        dbQuery {
            statement = UserTable.insert {
                it[login] = params.login
                it[password] = params.password
            }
        }
        return rowToUser(statement?.resultedValues?.get(0))
    }

    override suspend fun getUser(login: String): User? {
        val user = dbQuery {
            UserTable.select(UserTable.login.eq(login)).map { rowToUser(it) }.singleOrNull()
        }

        return user
    }

    private fun rowToUser(row: ResultRow?): User? {
        return if (row == null) null
        else User(
            row[UserTable.id],
            row[UserTable.login],
            row[UserTable.password]
        )
    }
}
