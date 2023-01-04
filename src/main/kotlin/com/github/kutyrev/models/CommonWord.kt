package com.github.kutyrev.models

private const val ENGLISH_LANGUAGE_ID = 0

data class CommonWord(val id: Int, val lang: Language, val word: String)

enum class Language(val id: Int){
    English(ENGLISH_LANGUAGE_ID)
}
