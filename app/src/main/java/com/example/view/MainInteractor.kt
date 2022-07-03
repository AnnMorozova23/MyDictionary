package com.example.view

import com.example.mydictionary.data.AppState
import com.example.mydictionary.data.DataModel
import com.example.mydictionary.presenter.Interactor
import com.example.mydictionary.repository.Repository

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                remoteRepository
            } else {
                localRepository
            }.getData(word)
        )
    }
}