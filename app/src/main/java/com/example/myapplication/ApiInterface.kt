package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
 @GET("posts/{postId}")
 fun getPostById(@Path("id")postId:Int):Call<Post>
@GET("post/id/{comments}")
fun getComments(@Path("comments")comments:String):Call<Post>


    }
