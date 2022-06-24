package me.ktz.userinfo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.ktz.userinfo.data.local.room.UserInfoDatabase
import me.ktz.userinfo.data.local.room.dao.UserInfoDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomDatabaseModule {

    @Singleton
    @Provides
    fun provideUserInfoDao(database: UserInfoDatabase): UserInfoDao = database.userInfoDao()

    @Provides
    fun providesDatabase(@ApplicationContext context: Context): UserInfoDatabase =
        UserInfoDatabase.getInstance(context)
}
