package me.ktz.userinfo.data.models.remote // ktlint-disable filename

import com.google.gson.annotations.SerializedName
import me.ktz.userinfo.data.models.entities.UserInfoEntity
import java.io.Serializable

data class UserInfo(

    @SerializedName("address")
    val address: Address,
    @SerializedName("email")
    val email: String,
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
    data class Address(
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
fun UserInfo.toUserInfoEntity() = UserInfoEntity(
    address = address.toAddressEntity(),
    email = email,
    id = id,
    name = name,
    phone = phone,
    username = username,
    website = website
)

fun UserInfo.Address.toAddressEntity() =
    UserInfoEntity.AddressEntity(city = city, street = street, suite = suite, zipcode = zipcode)
