package com.example.schoolManagement.network;


import com.example.schoolManagement.model.Login;
import com.example.schoolManagement.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface BaseApiMethods {

    @POST("api-token-auth/")
    Call<User> login(@Body Login login);

//    Call<User> login(@Body LoginData login);

//    @GET("users_login_data/")
//    Call<List<Users>> getPost(@Header("Authorization")  String djangoToken);



}
