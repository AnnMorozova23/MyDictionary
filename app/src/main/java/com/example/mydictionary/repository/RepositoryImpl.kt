package com.example.mydictionary.repository

import com.example.mydictionary.data.DataModel
import com.example.mydictionary.datasource.DataSource
import io.reactivex.Observable


class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}