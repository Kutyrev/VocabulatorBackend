package com.github.kutyrev.database

import org.jetbrains.exposed.sql.Table

private const val USERS_TABLE_NAME = "users"
private const val ID_COLUMN_NAME = "id"
private const val LOGIN_COLUMN_NAME = "login"
private const val PASSWORD_COLUMN_NAME = "password"

object UserTable: Table(USERS_TABLE_NAME) {
    val id = integer(ID_COLUMN_NAME).autoIncrement()
    val login = varchar(LOGIN_COLUMN_NAME, 256)
    val password = text(PASSWORD_COLUMN_NAME)
    override val primaryKey = PrimaryKey(id)
}
