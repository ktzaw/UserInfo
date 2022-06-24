package me.ktz.userinfo.data.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import me.ktz.userinfo.data.models.remote.UserInfo
import java.io.Serializable

@Entity(tableName = "UserInfo")
data class UserInfoEntity(
    @SerializedName("address")
    val address: AddressEntity,
    @SerializedName("email")
    val email: String,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
) : Serializable {
    data class AddressEntity(
        @SerializedName("city")
        val city: String,
        @SerializedName("street")
        val street: String,
        @SerializedName("suite")
        val suite: String,
        @SerializedName("zipcode")
        val zipcode: String
    ) : Serializable
}

// Mappers
fun UserInfoEntity.toUserInfo() = UserInfo(
    address = address.toAddress(),
    email = email,
    id = id,
    name = name,
    phone = phone,
    username = username,
    website = website
)

fun UserInfoEntity.AddressEntity.toAddress() =
    UserInfo.Address(city = city, street = street, suite = suite, zipcode = zipcode)
