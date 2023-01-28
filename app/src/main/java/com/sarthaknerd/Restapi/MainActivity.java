package com.sarthaknerd.Restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
 ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        apiInterface  = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        apiInterface.getPosts().enqueue(new Callback<List<PostPojo>>() {

            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {
                if(response.body().size()>0){
                    Toast.makeText(MainActivity.this,"LIST IS NOT EMPTY",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"LIST IS EMPTY",Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}