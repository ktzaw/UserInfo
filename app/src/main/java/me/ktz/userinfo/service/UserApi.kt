package me.ktz.userinfo.service

import me.ktz.userinfo.data.models.remote.UserInfo
import retrofit2.http.GET

interface UserApi {

    // Network
    @GET("users")
    suspend fun loadUsers(): List<UserInfo>
}
