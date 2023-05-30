package com.serapercel.kisilerimuygulamasi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.serapercel.kisilerimuygulamasi.dao.ContactDAO
import com.serapercel.kisilerimuygulamasi.model.Contact

@Database(entities = [Contact::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun contactDAO(): ContactDAO

}