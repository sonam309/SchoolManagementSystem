package com.example.schoolManagement.Ui.viewModel;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.schoolManagement.model.ClassDataModel;
import com.example.schoolManagement.network.ApiClient;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassesViewModel extends ViewModel {

    Context context;

    public MutableLiveData<List<ClassDataModel>> classesData = new MutableLiveData<>();


    public void classData() {

        ApiClient.getBaseApiMethods().classes().enqueue(new Callback<List<ClassDataModel>>() {


            @Override
            public void onResponse(Call<List<ClassDataModel>> call, Response<List<ClassDataModel>> response) {

                ResponseBody errorBody = response.errorBody();

                if (response.isSuccessful()) {
                    List<ClassDataModel> classesViewModel = response.body();

                    if (classesViewModel != null) {

                        classesData.postValue(classesViewModel);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ClassDataModel>> call, Throwable t) {
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }


        });
    }


}
