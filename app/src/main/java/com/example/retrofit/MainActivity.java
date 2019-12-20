package com.example.retrofit;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialize();


///Create java class pojo(retrive pojo)
///create java class API (GET Request)

    }



    private void Initialize() {
        textView = (TextView)findViewById(R.id.textView);
        Api();

    }

    private void Api() {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(RetrofitAPI.url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();


                RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

                Call<List<RetrofitPojo>> call = retrofitAPI.getposts();

                call.enqueue(new Callback<List<RetrofitPojo>>() {
                    @Override
                    public void onResponse(Call<List<RetrofitPojo>> call, Response<List<RetrofitPojo>> response) {

                        if(!response.isSuccessful()){
                            textView.setText("code"+response.code());
                            return;
                        }
                        List<RetrofitPojo> posts  = response.body();

                        for(RetrofitPojo retrofitPojo :posts){

                            String content = "";
                            content += "id"+ retrofitPojo.getId()+"\n" ;
                            content += "userid"+ retrofitPojo.getUserid()+"\n" ;
                            content += "title"+ retrofitPojo.getTitle()+"\n" ;
                            content += "body"+ retrofitPojo.getBody()+"\n\n" ;

                            textView.setText(content);
                        }


                        Log.i("respose", response.toString());

                        Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override

                    public void onFailure(Call<List<RetrofitPojo>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();

                    }
                });
    }

}
