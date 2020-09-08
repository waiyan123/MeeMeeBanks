package com.example.meemeebanks.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.meemeebanks.data.vos.BankVO

@Dao
abstract class BankDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertBanksList(banksList: List<BankVO>): LongArray

    @Query("SELECT * FROM bank_table")
    abstract fun getBanksList(): LiveData<List<BankVO>>
}