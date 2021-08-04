package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvPost:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPost=findViewById(R.id.rvPosts)
        var post=LinearLayoutManager(baseContext)
        fetchPosts()

    }
    fun fetchPosts(){
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback <List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var postList=response.body()
                   if (postList!=null){
                    var postsAdapter=PostsRvAdapter(postList,baseContext)
                    rvPost.adapter=postsAdapter

                    Toast.makeText(baseContext, "${postList?.size} posts", Toast.
                    LENGTH_LONG).show()

                }}
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
           Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }

}