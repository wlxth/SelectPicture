package com.cui.mrr.http;


import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cuiyang on 16/6/1.
 */
public class ApiClient {
    private static ApiService API_SERVICE;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static ApiService getApiService() {
        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(OkHttpClientSingle.getInstance())
                    .baseUrl("http://119.29.96.105:8080/DriveSchool/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            API_SERVICE = retrofit.create(ApiService.class);
        }
        return API_SERVICE;
    }
}
