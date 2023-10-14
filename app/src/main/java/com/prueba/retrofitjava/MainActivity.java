package com.prueba.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.prueba.retrofitjava.databinding.ActivityMainBinding;
import com.prueba.retrofitjava.models.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupRetrofit();
    }

    private void setupRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);

        userService.getUser("3").enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                var data = response.body();
                binding.text.setText(data.getData().getFirst_name() + " " + data.getData().getLast_name());
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                binding.text.setText(t.getMessage());
            }
        });
    }
}