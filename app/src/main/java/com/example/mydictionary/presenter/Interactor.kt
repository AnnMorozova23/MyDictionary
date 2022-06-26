package com.example.mydictionary.presenter


interface Interactor<T> {
    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}