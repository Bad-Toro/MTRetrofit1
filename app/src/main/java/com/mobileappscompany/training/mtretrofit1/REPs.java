package com.mobileappscompany.training.mtretrofit1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ferna on 6/7/2017.
 */

public interface REPs {

    @GET("posts")
    Call<List<Post>> getAllPosts();


    @GET("posts")
    Call<List<Post>> getPostByUser(@Query("userId") Integer userId);
}
