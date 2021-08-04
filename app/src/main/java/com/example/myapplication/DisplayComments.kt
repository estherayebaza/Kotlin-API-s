package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayComments : AppCompatActivity() {
    lateinit var rvComments:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvComments=findViewById(R.id.cvComments)
        var comments=LinearLayoutManager(baseContext)
        fetchComments()

    }
    fun fetchComments(){
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object : Callback <List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var commentsList=response.body()
                    if (commentsList!=null){
                        var commentsAdapter=PostsRvAdapter(commentsList,baseContext)
                        rvComments.adapter=commentsAdapter

                        Toast.makeText(baseContext, "${commentsList?.size} posts", Toast.
                        LENGTH_LONG).show()


                    }}
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })
    }

}