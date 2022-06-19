package com.example.view

import androidx.appcompat.app.AppCompatActivity
import com.example.mydictionary.ViewModel.BaseViewModel
import com.example.mydictionary.data.AppState



abstract class BaseActivity<T : AppState> : AppCompatActivity(), View {

//    abstract val model: BaseViewModel<T>

    abstract override fun renderData(appState: AppState)

}