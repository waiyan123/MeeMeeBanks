package com.example.meemeebanks.di

import androidx.room.Room
import com.example.meemeebanks.data.models.BankModelImpl
import com.example.meemeebanks.network.MainApi
import com.example.meemeebanks.network.dataagents.BankListDataAgentImpl
import com.example.meemeebanks.persistence.MyDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module(override = true) {


    single {
        MainApi.getInstance()
    }

    single {
        BankListDataAgentImpl()
    }

    single {
        BankModelImpl()
    }

    single {
        Room.databaseBuilder(androidContext(), MyDatabase::class.java,"my_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}