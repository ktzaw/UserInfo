package me.ktz.userinfo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.ktz.userinfo.data.local.room.dao.UserInfoDao
import me.ktz.userinfo.repositories.UserInfoRepository
import me.ktz.userinfo.repositories.UserInfoRepositoryImpl
import me.ktz.userinfo.service.UserApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUserInfoRepository(api: UserApi, dao: UserInfoDao): UserInfoRepository = UserInfoRepositoryImpl(api, dao)
}
