package me.ktz.userinfo.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import me.ktz.userinfo.data.local.room.dao.UserInfoDao
import me.ktz.userinfo.data.local.room.typeConverters.AddressTypeConverter
import me.ktz.userinfo.data.models.entities.UserInfoEntity

@Database(version = 1, entities = [UserInfoEntity::class], exportSchema = false)
@TypeConverters(AddressTypeConverter::class)
abstract class UserInfoDatabase : RoomDatabase() {

    abstract fun userInfoDao(): UserInfoDao

    companion object {
        private const val DB_NAME = "UserInfo.db"
        private var databaseInstance: UserInfoDatabase? = null

        fun getInstance(context: Context): UserInfoDatabase = synchronized(this) {
            when (databaseInstance) {
                null -> {
                    databaseInstance = initDatabase(context)
                }
            }
            return databaseInstance!!
        }

        private fun initDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                UserInfoDatabase::class.java,
                DB_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}
