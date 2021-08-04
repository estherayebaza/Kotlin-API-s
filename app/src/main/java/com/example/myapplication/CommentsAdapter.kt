package com.example.myapplication

//class CommentsAdapter {
//}

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentsAdapter(var commentList:List<Comments>,var context: Context):RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_display_comments,parent,false)
        return CommentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=commentList.get(position)
        holder.tvCommentId.text=currentComment.id.toString()
        holder.tvCommentPostId.text=currentComment.PostId.toString()
        holder.tvCommentBody.text=currentComment.body
        holder.tvCommentEmail.text=currentComment.email
        holder.tvCommentName.text=currentComment.name
//        var intent = Intent(context2, ViewPostActivity::class.java)
//        //intent.putExtra("POST_ID", currentPost.id)
//       // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        context2.startActivity(intent)
//    }
    }

    override fun getItemCount(): Int {
        return  commentList.size
    }
}
class CommentsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvCommentName=itemView.findViewById<TextView>(R.id.tvCommentName)
    var tvCommentBody=itemView.findViewById<TextView>(R.id.tvCommentBody)
    var tvCommentEmail=itemView.findViewById<TextView>(R.id.tvCommentEmail)
    var tvCommentId=itemView.findViewById<TextView>(R.id.tvCommentId)
    var tvCommentPostId=itemView.findViewById<TextView>(R.id.tvCommentPostId)
}
