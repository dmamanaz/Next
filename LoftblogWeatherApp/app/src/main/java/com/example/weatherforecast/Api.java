package com.example.weatherforecast;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public interface Api {

    static String DOMAIN = "https://home.openweathermap.org";

    class Instance {
        public static Retrofit getRetrofit() {

            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

            Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
            retrofitBuilder.baseUrl(DOMAIN);
            retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
            retrofitBuilder.callAdapterFactory();
            retrofitBuilder.client(okHttpClientBuilder.build());

            return retrofitBuilder.build();

        }
    }
}
