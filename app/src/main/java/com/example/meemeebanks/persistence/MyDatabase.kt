package com.example.meemeebanks.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.meemeebanks.data.vos.BankVO
import com.example.meemeebanks.persistence.daos.BankDao
import org.koin.core.KoinComponent

@Database(entities = arrayOf(BankVO::class),version = 2,exportSchema = false)
abstract class MyDatabase : RoomDatabase(), KoinComponent {

    abstract fun bankDao() : BankDao

}