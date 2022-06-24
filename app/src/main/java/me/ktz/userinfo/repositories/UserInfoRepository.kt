package me.ktz.userinfo.repositories

import kotlinx.coroutines.flow.Flow
import me.ktz.userinfo.data.models.remote.UserInfo

interface UserInfoRepository {

    // Remote
    fun loadUsers(): Flow<List<UserInfo>>

    // Local
    suspend fun insertAllUsersInfo(userInfoList: List<UserInfo>)
    fun getAllUsers(): Flow<List<UserInfo>>
    suspend fun deleteAllUserInfo()
}
