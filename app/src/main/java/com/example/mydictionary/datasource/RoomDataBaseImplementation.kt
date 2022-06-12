package com.example.mydictionary.datasource

import com.example.mydictionary.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImplementation:DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("Not yet implemented")
    }
}