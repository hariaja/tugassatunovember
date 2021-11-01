package com.kelompoktiga.tugaspertemuantiga.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
//  private static Retrofit retrofit = null;
//
//  public static Retrofit getClient(String baseUrl){
//    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
//
//    if (retrofit == null){
//      retrofit = new Retrofit.Builder()
//          .baseUrl(baseUrl)
//          .addConverterFactory(GsonConverterFactory.create())
//          .client(client)
//          .build();
//    }
//    return retrofit;
//  }

  private static String BASE_URL = "http://192.168.1.3/belajar-api/public/";
  private static RetrofitClient retrofitClient;
  private static Retrofit retrofit;

  private RetrofitClient() {
    retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public static synchronized RetrofitClient getInstance() {
    if (retrofitClient == null) {
      retrofitClient = new RetrofitClient();
    }
    return retrofitClient;
  }

  public BaseApiService getApi(){
    return retrofit.create(BaseApiService.class);
  }
}
