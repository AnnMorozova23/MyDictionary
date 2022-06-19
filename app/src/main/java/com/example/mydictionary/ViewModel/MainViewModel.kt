package com.example.mydictionary.ViewModel

import androidx.lifecycle.LiveData
import com.example.mydictionary.data.AppState
import com.example.mydictionary.datasource.DataSourceLocal
import com.example.mydictionary.datasource.DataSourceRemote
import com.example.mydictionary.repository.RepositoryImpl
import com.example.view.MainInteractor
import io.reactivex.observers.DisposableObserver

class MainViewModel(private val interactor: MainInteractor): BaseViewModel<AppState>() {
    private var appState: AppState? = null

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe {
                    liveDataForViewToObserve.value =
                        AppState.Loading(null)
                }
                .subscribeWith(getObserver())
        )
        return super.getData(word, isOnline)
    }
    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {
            override fun onNext(state: AppState) {

                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {

            }

        }
    }

}