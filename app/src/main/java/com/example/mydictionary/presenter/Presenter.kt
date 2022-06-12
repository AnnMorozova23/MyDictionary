package com.example.mydictionary.presenter

import com.example.view.View
import com.example.mydictionary.data.AppState

interface Presenter<T : AppState, V : View> {
    fun attachView(view: View)
    fun detachView(view: View)
    fun getData(word: String, isOnline: Boolean)

}