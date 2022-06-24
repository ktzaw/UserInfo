package me.ktz.userinfo.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.ktz.userinfo.data.models.remote.UserInfo
import me.ktz.userinfo.databinding.ListItemUserBinding

class UserListAdapter(private val onUserClicked: (UserInfo) -> Unit) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var mData: MutableList<UserInfo> = ArrayList()

    fun setData(userList: List<UserInfo>) {
        this.mData.clear()
        this.mData.addAll(userList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemUserBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class UserViewHolder(private val binding: ListItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: UserInfo) = with(itemView) {
            binding.tvName.text = data.name
            binding.tvEmail.text = data.email
            this.setOnClickListener {
                onUserClicked.invoke(data)
            }
        }
    }
}
