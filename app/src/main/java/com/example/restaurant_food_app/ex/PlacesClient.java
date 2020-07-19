//package com.example.restaurant_food_app.home.api;
//
//import java.util.concurrent.TimeUnit;
//
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class PlacesClient {
//
//    private static final String BASE_URL = "http://172.16.0.96/webproject/public/";
//
//    public static Retrofit getFoodClient() {
//        return new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(provideOkHttp())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//
//    private static Interceptor provideLoggingInterceptor() {
//        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
//    }
//
//    private static OkHttpClient provideOkHttp() {
//        return new OkHttpClient.Builder()
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .writeTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .addNetworkInterceptor(provideLoggingInterceptor())
//                .build();
//    }
//}
