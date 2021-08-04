package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.ApiClient
import com.example.myapplication.ApiInterface
import com.example.myapplication.Post
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewPosts : AppCompatActivity() {
    var postId=0
    lateinit var tvPostTitle: TextView
    lateinit var  tvPostBody: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_posts)
        postId= intent.getIntExtra("POST_ID",0)

        tvPostTitle= findViewById(R.id.tvPostTitle)
        tvPostBody= findViewById(R.id.tvPostBody)
        fetchPostById()
    }
    fun fetchPostById(){
        var apiClient= ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post = response.body()
                    tvPostBody.text = post?.body
                    tvPostTitle.text= post?.title
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()            }
        })
    }
}