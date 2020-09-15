package com.example.schoolManagement.Ui.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.schoolManagement.model.Login;
import com.example.schoolManagement.model.User;
import com.example.schoolManagement.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {


    public MutableLiveData<User> logIn = new MutableLiveData<>();


    public void loginFun(String userName, String password) {
        ApiClient.getBaseApiMethods().login(new Login(userName, password)).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (response.body() != null) {
                        if (user.getToken() != null) {

                            logIn.postValue(user);
                        }

                    }

                }


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {


            }


        });

    }
}