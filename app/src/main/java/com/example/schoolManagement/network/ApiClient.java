package com.example.schoolManagement.network;

import android.content.Intent;
import android.util.Log;

import androidx.core.view.ScaleGestureDetectorCompat;

import com.example.schoolManagement.BuildConfig;
import com.example.schoolManagement.utility.KeyClass;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ApiClient {

    private static Retrofit retrofitBaseApi = null;

    private static OkHttpClient okHttpClient = null;
    private static GsonConverterFactory gsonConverterFactory = null;

    public static BaseApiMethods getBaseApiMethods() {
        return createRetrofitBase().create(BaseApiMethods.class);
    }

    private static Retrofit createRetrofitBase() {
        if (retrofitBaseApi == null) {

            retrofitBaseApi = new Retrofit.Builder()
                    .baseUrl(KeyClass.BASE_URL)
                    .addConverterFactory(getGsonConverter())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofitBaseApi;
    }

    public static OkHttpClient getOkHttpClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        if (BuildConfig.DEBUG)
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        // add logging as last interceptor
        httpClient.addInterceptor(logging);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                okhttp3.Response response = chain.proceed
                        (request);
                // todo deal with the issues the way you need to
                if (response.code() == 403 || response.code() == 401) {
                    logoutSuccessfully();

                    return response;
                }
                Log.e("response of app", response.toString());
                return response;

            }
        });
        okHttpClient = httpClient.build();

        return okHttpClient;
    }

    public static void logoutSuccessfully() {
        // clear preference data

    }

    private static GsonConverterFactory getGsonConverter() {

            if (gsonConverterFactory == null) {
                Gson gson = gson = new GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation().serializeNulls().create();
                gsonConverterFactory = GsonConverterFactory.create(gson);
            }
            return gsonConverterFactory;
        }


}