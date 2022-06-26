package com.example.mydictionary.repository


interface Repository<T> {
    suspend fun getData(word: String): T
}