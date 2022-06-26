package com.example.mydictionary.datasource


interface DataSource<T> {
    suspend fun getData(word: String): T
}