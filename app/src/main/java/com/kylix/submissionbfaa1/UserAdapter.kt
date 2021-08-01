package com.kylix.submissionbfaa1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kylix.submissionbfaa1.DetailActivity.Companion.EXTRA_USER
import com.kylix.submissionbfaa1.databinding.ItemUserListBinding
import com.kylix.submissionbfaa1.model.User

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val userList = ArrayList<User>()

    fun setAllData(data: List<User>) {
        userList.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = ItemUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

    inner class UserViewHolder(private val view: ItemUserListBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(user: User) {

            view.apply {
                tvListUsername.text = user.username
                tvListName.text = user.name
            }

            Glide.with(itemView.context)
                .load(user.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(view.ivListUser)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra(EXTRA_USER, user)
                itemView.context.startActivity(intent)
            }
        }
    }
}