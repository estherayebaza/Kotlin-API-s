package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.ViewPosts


class PostsRvAdapter (var PostList:List<Post>,var context:Context):RecyclerView.Adapter<ViewHolderPost>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        var itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.posts_item,parent,false)
        return ViewHolderPost(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        var currentPost=PostList.get(position)
        holder.tvTitle.text=currentPost.title.toString()
        holder.tvBody.text=currentPost.body.toString()
        holder.cvcard.setOnClickListener {

var intent=Intent(context, ViewPosts::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
       return PostList.size
    }
}
class ViewHolderPost(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTitle)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var cvcard=itemView.findViewById<CardView>(R.id.cvPosts)
}