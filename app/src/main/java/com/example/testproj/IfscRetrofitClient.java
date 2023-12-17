package com.example.testproj;

import com.example.testproj.models.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IfscRetrofitClient {
    private static Retrofit retrofit;

    public static Retrofit getInstance() {
        if (retrofit == null) {
            OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS) // Set connection timeout
                    .readTimeout(60, TimeUnit.SECONDS);

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.IFSC_BASE_URL)
                    .client(httpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
