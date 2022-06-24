package me.ktz.userinfo.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.ktz.userinfo.data.models.entities.UserInfoEntity

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(userInfoList: List<UserInfoEntity>)

    @Query("SELECT * FROM UserInfo")
    fun getAllUsers(): Flow<List<UserInfoEntity>>

    @Query("DELETE FROM UserInfo")
    fun deleteAllUserInfo()
}
