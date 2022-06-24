package me.ktz.userinfo.data.local.room.typeConverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import me.ktz.userinfo.data.models.entities.UserInfoEntity

class AddressTypeConverter {

    @TypeConverter
    fun fromJsonToAvatar(json: String): UserInfoEntity.AddressEntity? {
        val typeToken = object : TypeToken<UserInfoEntity.AddressEntity>() {}.type
        return Gson().fromJson(json, typeToken)
    }

    @TypeConverter
    fun fromAvatarToJson(avatar: UserInfoEntity.AddressEntity?): String {
        return Gson().toJson(avatar)
    }
}
