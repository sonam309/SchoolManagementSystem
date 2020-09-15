package com.example.schoolManagement.Ui.viewModel;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.schoolManagement.model.UserProfileDetailModel;
import com.example.schoolManagement.network.ApiClient;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileDetailViewModel extends ViewModel {

    Context context;


    public MutableLiveData<List<UserProfileDetailModel>> userProfileDetail = new MutableLiveData<>();


    public void userProfileDetail(Context context) {
        this.context = context;

        ApiClient.getBaseApiMethods().userprofiledetail().enqueue(new Callback<List<UserProfileDetailModel>>() {


            @Override
            public void onResponse(Call<List<UserProfileDetailModel>> call, Response<List<UserProfileDetailModel>> response) {

                ResponseBody errorBody = response.errorBody();
                if (response.isSuccessful()) {
                    List<UserProfileDetailModel> userProfileDetailModel = response.body();

                    if (userProfileDetailModel != null) {

                        userProfileDetail.postValue(userProfileDetailModel);

                    }

                }

            }

            @Override
            public void onFailure(Call<List<UserProfileDetailModel>> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("aaaaaa", t.getMessage());

            }
        });
    }

}
