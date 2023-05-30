package com.serapercel.kisilerimuygulamasi.di

import android.content.Context
import androidx.room.Room
import com.serapercel.kisilerimuygulamasi.data.datasource.ContactDatasource
import com.serapercel.kisilerimuygulamasi.data.repository.ContactRepository
import com.serapercel.kisilerimuygulamasi.room.dao.ContactDAO
import com.serapercel.kisilerimuygulamasi.room.database.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideContactRepository(cds: ContactDatasource): ContactRepository {
        return ContactRepository(cds)
    }

    @Provides
    @Singleton
    fun provideContactDatasource(cdao: ContactDAO): ContactDatasource {
        return ContactDatasource(cdao)
    }

    @Provides
    @Singleton
    fun provideContactDAO(@ApplicationContext context: Context): ContactDAO {
        val db = Room.databaseBuilder(context, Database::class.java, "contacts.sqlite")
            .createFromAsset("contacts.sqlite").build()
        return db.contactDAO()

    }
}