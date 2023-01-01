package com.github.kutyrev.database

import org.jetbrains.exposed.sql.Table

private const val COMMON_WORDS_TABLE_NAME = "common_words"
private const val ID_COLUMN_NAME = "id"
private const val LANG_COLUMN_NAME = "lang"
private const val WORD_COLUMN_NAME = "word"

object CommonWordsTable: Table(COMMON_WORDS_TABLE_NAME) {
    val id = integer(ID_COLUMN_NAME).autoIncrement()
    val lang = integer(LANG_COLUMN_NAME)
    val word = text(WORD_COLUMN_NAME)
    override val primaryKey = PrimaryKey(id)
}
