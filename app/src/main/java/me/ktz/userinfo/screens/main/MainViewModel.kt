package me.ktz.userinfo.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.ktz.userinfo.data.models.remote.UserInfo
import me.ktz.userinfo.repositories.UserInfoRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserInfoRepository
) : ViewModel() {

    private var _userInfoList: MutableStateFlow<List<UserInfo>> = MutableStateFlow(emptyList())
    val userInfoList: StateFlow<List<UserInfo>> = _userInfoList

    fun loadUsers() {
        viewModelScope.launch {
            repository.loadUsers().collect {
                overwriteLocalData(it)
            }
        }
    }

    // Overwrite local database with new data if changed
    private fun overwriteLocalData(userInfoList: List<UserInfo>) {
        viewModelScope.launch {
            launch {
                repository.deleteAllUserInfo()
            }
            launch {
                repository.insertAllUsersInfo(userInfoList)
            }
        }
    }

    // Get local data
    fun getUserInfo() {
        viewModelScope.launch {
            repository.getAllUsers().collect {
                _userInfoList.value = it
            }
        }
    }
}
