package com.example.lks_linhkienshop.retrofit;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    private static String BASE_URL = "http://192.168.1.50:8080/";

    //private static String BASE_URL = "http://192.168.1.93:8080/";
    private static Retrofit retrofit;
    private static Gson gson;

    public static Retrofit getClinet(){
        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
