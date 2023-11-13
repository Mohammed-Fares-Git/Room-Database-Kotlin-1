package com.example.room_database_tuto.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.room_database_tuto.TestinViewModelFactory
import com.example.room_database_tuto.TestingActivity
import com.example.room_database_tuto.TestingViewModel
import com.example.room_database_tuto.db.AppartementDatabase
import com.example.room_database_tuto.repositry.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provodeRepositry (appartementDatabase: AppartementDatabase): Repository {
        return Repository(appartementDatabase)
    }

    @Singleton
    @Provides
    fun provodeDbInstece (@ApplicationContext context: Context): AppartementDatabase {
        return AppartementDatabase.getInstance(context)
    }


    @Singleton
    @Provides
    fun provodeTestinViewModel (@ActivityContext context: Context,repository: Repository): TestingViewModel {
        return ViewModelProvider((context as TestingActivity), TestinViewModelFactory(repository))
            .get(TestingViewModel::class.java)
    }
}
