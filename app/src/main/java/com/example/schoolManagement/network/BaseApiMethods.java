package com.example.schoolManagement.network;


import com.example.schoolManagement.model.ClassDataModel;
import com.example.schoolManagement.model.UserLoginDetailModel;
import com.example.schoolManagement.model.Login;
import com.example.schoolManagement.model.User;
import com.example.schoolManagement.model.UserProfileDetailModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiMethods {

    @POST("api-token-auth/")
    Call<User> login(@Body Login login);

//    Call<User> login(@Body LoginData login);

    @GET("users_login_data/")
    Call<List<UserLoginDetailModel>> userLogindetail();

    @GET("api/userprofile/")
    Call<List<UserProfileDetailModel>>userprofiledetail();

    @GET("api/class_data/")
    Call<List<ClassDataModel>>classes();



}
