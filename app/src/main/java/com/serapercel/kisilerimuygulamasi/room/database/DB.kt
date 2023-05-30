package com.serapercel.kisilerimuygulamasi.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.serapercel.kisilerimuygulamasi.room.dao.ContactDAO
import com.serapercel.kisilerimuygulamasi.room.entity.Contact

@Database(entities = [Contact::class], version = 2)
abstract class DB : RoomDatabase() {

    abstract fun contactDAO(): ContactDAO

}