package com.example.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPostRequest extends AppCompatActivity {

    TextView PostTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_post_request);

        initialize();
        CreatePost();
    }

    private void initialize() {

        PostTxtView = (TextView)findViewById(R.id.PostTxtView);
    }

    private void CreatePost() {

        PostRequestPojo postRequestPojo = new PostRequestPojo(23 ,"Title","Text");

//        Map<String, String> fields = new HashMap<>();
//        fields.put("userid","32");
//        fields.put("title","king");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitAPI.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        PostRequestApi postRequestApi = retrofit.create(PostRequestApi.class);

        Call<PostRequestPojo> call = postRequestApi.createPost(postRequestPojo);

        call.enqueue(new Callback<PostRequestPojo>() {
            @Override
            public void onResponse(Call<PostRequestPojo> call, Response<PostRequestPojo> response) {

                if(!response.isSuccessful()){
                    PostTxtView.setText("code"+response.code());
                    return;
                }

                PostRequestPojo postRequestPojo1  = response.body();

                    String content = "";
                    content +="code :"+response.code()+"\n";
                    content += "id :"+ postRequestPojo1.getId()+"\n" ;
                    content += "user id :"+ postRequestPojo1.getUserid()+"\n" ;
                    content += "title :"+ postRequestPojo1.getTitle()+"\n" ;
                    content += "body :"+ postRequestPojo1.getBody()+"\n\n" ;

                    PostTxtView.setText(content);

            }

            @Override
            public void onFailure(Call<PostRequestPojo> call, Throwable t) {

                PostTxtView.setText(t.getMessage());
            }
        });

    }
}
