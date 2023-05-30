package com.serapercel.kisilerimuygulamasi.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.serapercel.kisilerimuygulamasi.room.dao.ContactDAO
import com.serapercel.kisilerimuygulamasi.room.entity.Contact

@Database(entities = [Contact::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun contactDAO(): ContactDAO

}