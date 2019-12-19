package com.example.retrofit;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;

public interface RetrofitAPI {

    String url = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<RetrofitPojo>> getposts();



}
