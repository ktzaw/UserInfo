package me.ktz.userinfo.screens.main

import android.content.Intent
import android.content.Intent.EXTRA_USER
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.ktz.userinfo.data.models.remote.UserInfo
import me.ktz.userinfo.databinding.ActivityMainBinding
import me.ktz.userinfo.recyclerviews.UserListAdapter
import me.ktz.userinfo.screens.detail.ProfileDetailActivity
import java.net.InetSocketAddress
import java.net.Socket

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val mAdapter by lazy {
        UserListAdapter() { userInfo: UserInfo ->
            onUserClicked(userInfo)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpAdapters(mAdapter)
        loadUsersData()
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.swipeRefreshLayout.setOnRefreshListener {

            binding.swipeRefreshLayout.isRefreshing = false

            lifecycleScope.launch {
                if (isAppOnline()) {
                    viewModel.loadUsers()
                    viewModel.getUserInfo()
                    loadUsersData()
                } else {
                    makeToast("Please check your network and try again.", Toast.LENGTH_SHORT)
                    loadUsersData()
                }
            }
        }
    }

    private fun loadUsersData() {

        lifecycleScope.launch {
            if (isAppOnline()) {
                launch {
                    viewModel.loadUsers()
                }
                launch {
                    viewModel.getUserInfo()
                }
                launch {
                    viewModel.userInfoList.collect {
                        mAdapter.setData(it)
                    }
                }
            } else {
                viewModel.getUserInfo()
                viewModel.userInfoList.collect {
                    mAdapter.setData(it)
                }
            }
        }
    }

    private fun setUpAdapters(mAdapter: UserListAdapter) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvUserList.adapter = mAdapter
        binding.rvUserList.layoutManager = layoutManager
    }

    private fun onUserClicked(userInfo: UserInfo) {
        val intent = Intent(this@MainActivity, ProfileDetailActivity::class.java)
        intent.putExtra(EXTRA_USER, userInfo)
        startActivity(intent)
    }

    // Network Connectivity
    private suspend fun isAppOnline(): Boolean = withContext(Dispatchers.IO) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val connectivityManager =
                this@MainActivity.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true) {
                return@withContext testConnection()
            } else {
                return@withContext false
            }
        }
        return@withContext true
    }

    private fun testConnection(): Boolean =
        try {
            val socket = Socket()
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            true
        } catch (e: Exception) {
            false
        }

    // Makring Toasts
    private fun makeToast(message: String, length: Int) {
        Toast.makeText(this, message, length).show()
    }
}
