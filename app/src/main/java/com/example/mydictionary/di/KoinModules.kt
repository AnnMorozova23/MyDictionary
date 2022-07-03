package com.example.mydictionary.di

import com.example.mydictionary.ViewModel.MainViewModel
import com.example.mydictionary.data.DataModel
import com.example.mydictionary.datasource.RetrofitImplementation
import com.example.mydictionary.datasource.RoomDataBaseImplementation
import com.example.mydictionary.repository.Repository
import com.example.mydictionary.repository.RepositoryImpl
import com.example.view.MainInteractor
import org.koin.core.qualifier.named
import org.koin.dsl.module

val NAME_REMOTE: String = "NAME_REMOTE"
val NAME_LOCAL: String = "NAME_LOCAL"

val application = module {

    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImpl(RetrofitImplementation())
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImpl(RoomDataBaseImplementation())
    }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
