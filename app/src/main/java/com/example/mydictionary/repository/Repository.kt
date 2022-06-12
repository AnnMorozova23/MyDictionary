package com.example.mydictionary.repository

import io.reactivex.Observable


interface Repository<T> {
    fun getData(word: String): Observable<T>
}