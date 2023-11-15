package com.example.vinted.Util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliente {

    public static final String IP_BASE = "192.168.192.1:8099";
    private static Retrofit retrofit = null;
    // Crear una instancia personalizada de Gson que sea leniente
    //static Gson gson = new GsonBuilder().setLenient().create();
    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
