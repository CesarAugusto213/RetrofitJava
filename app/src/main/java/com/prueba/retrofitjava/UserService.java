package com.prueba.retrofitjava;

import com.prueba.retrofitjava.models.UserData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("/api/users/{id}")
    Call<UserData> getUser(@Path("id") String id);
}