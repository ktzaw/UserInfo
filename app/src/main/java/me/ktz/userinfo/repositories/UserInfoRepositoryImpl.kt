package me.ktz.userinfo.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import me.ktz.userinfo.data.local.room.dao.UserInfoDao
import me.ktz.userinfo.data.models.entities.toUserInfo
import me.ktz.userinfo.data.models.remote.UserInfo
import me.ktz.userinfo.data.models.remote.toUserInfoEntity
import me.ktz.userinfo.service.UserApi
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val userInfoDao: UserInfoDao
) : UserInfoRepository {

    override fun loadUsers(): Flow<List<UserInfo>> {
        return flow {
            val userList = api.loadUsers()
            emit(userList)
        }.flowOn(Dispatchers.IO)
    }

    // Saving all users to local
    override suspend fun insertAllUsersInfo(userInfoList: List<UserInfo>) {
        userInfoDao.insertAllUsers(userInfoList.map { it.toUserInfoEntity() })
    }

    // Getting all users from local
    override fun getAllUsers(): Flow<List<UserInfo>> =
        userInfoDao.getAllUsers().map { userInfoEntityList ->
            userInfoEntityList.map {
                it.toUserInfo()
            }
        }

    // Deleting all users
    override suspend fun deleteAllUserInfo() {
        userInfoDao.deleteAllUserInfo()
    }
}
