package com.example.schoolManagement.Ui.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.schoolManagement.model.Login;
import com.example.schoolManagement.model.User;
import com.example.schoolManagement.network.ApiClient;
import com.example.schoolManagement.utility.utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {


    public MutableLiveData<Login> logIn = new MutableLiveData<>();


    public void loginFun(String userName, String password) {
        ApiClient.getBaseApiMethods().login(new Login(userName, password, utils.getDeviceToken())).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){


                    }
                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }


        });

    }
}