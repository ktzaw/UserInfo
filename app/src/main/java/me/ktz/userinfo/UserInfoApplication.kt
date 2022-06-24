package me.ktz.userinfo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UserInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
