package com.mobileappscompany.training.mtretrofit1;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ferna on 6/7/2017.
 */

public class RControler implements Callback<List<Post>> {


    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public RControler() {

    }

    public void start(int userId){
        Gson gs = new GsonBuilder().setLenient().create();

        Retrofit r = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gs))
                .build();

        REPs myAPI = r.create(REPs.class);
        if(userId<1) {
            Call<List<Post>> call = myAPI.getAllPosts();
            call.enqueue(this);
        } else  {
            Call<List<Post>> call = myAPI.getPostByUser(userId);
            call.enqueue(this);
        }
    }

    @Override
    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
        if(response.isSuccessful()){
            StringBuilder sb = new StringBuilder();
            for (Post p: response.body()){
                sb.append(p.getId() + " - " + p.getTitle() + "\n");
            }
            Log.d("MAC_Tag", sb.toString());
        }
    }

    @Override
    public void onFailure(Call<List<Post>> call, Throwable t) {

    }
}
