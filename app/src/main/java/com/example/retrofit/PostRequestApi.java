package com.example.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostRequestApi {
    String url = "https://jsonplaceholder.typicode.com/";



    @POST("posts")
    Call<PostRequestPojo> createPost(@Body PostRequestPojo post);

    @FormUrlEncoded
    @POST("posts")

    Call<PostRequestPojo> createPost(
            @Field("userid") int userid,
            @Field("title") String title,
            @Field("body") String text
    );


//    @FormUrlEncoded
//    @POST("posts")
//
//    Call<PostRequestPojo> createPost(@FieldMap Map<String,String> fields);
}
