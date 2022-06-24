package me.ktz.userinfo.screens.detail

import android.R
import android.content.Intent.EXTRA_USER
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import me.ktz.userinfo.data.models.remote.UserInfo
import me.ktz.userinfo.databinding.ActivityProfileDetailBinding

@AndroidEntryPoint
class ProfileDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        handleToolbar()

        getIntentData()
        setUpUi(getIntentData())
    }

    private fun setUpUi(data: UserInfo) {

        binding.tvName.text = data.name
        binding.tvEmail.text = data.email

        // Getting address from address data class
        val address = "${data.address.street}, ${data.address.suite}, ${data.address.city}, ${data.address.zipcode}"
        binding.tvAddress.text = address

        binding.tvPhone.text = data.phone
        binding.tvWebsite.text = data.website
    }

    private fun getIntentData(): UserInfo =
        intent.getSerializableExtra(EXTRA_USER) as UserInfo

    private fun handleToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(@NonNull item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
