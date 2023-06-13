package com.example.myamazonmusicplayer.di

import android.app.Application
import com.example.myamazonmusicplayer.presenter.utils.LWAUtil
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
    fun provideLWAUtil() : LWAUtil {
        return LWAUtil()
    }

}