package com.kirei.githubapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kirei.githubapp.R
import com.kirei.githubapp.model.Users

class FollowingAdapter : RecyclerView.Adapter<FollowingAdapter.FollowingViewHolder>() {
    private val users = ArrayList<Users>()

    inner class FollowingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemUserBinding = ItemUserBinding.bind(itemView)

        fun bind(user: Users) {
            itemUserBinding.tvItemUsername.text = user.username
            Glide.with(itemView.context).load(user.avatar)
                .apply(RequestOptions().override(55, 55))
                .into(itemUserBinding.ivItemUser)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return FollowingViewHolder(view)
    }

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size
}
