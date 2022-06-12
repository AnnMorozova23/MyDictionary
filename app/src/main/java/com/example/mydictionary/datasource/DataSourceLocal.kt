package com.example.mydictionary.datasource

import com.example.mydictionary.data.DataModel

import io.reactivex.Observable

class DataSourceLocal(private  val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation())
    :DataSource <List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)

}