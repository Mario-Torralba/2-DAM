package com.example.vinted.Util;


import com.example.vinted.Login.data.MyData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @GET("Controller")
    Call<MyData> getDataUser(@Query("ACTION") String action);

    //@GET("MyServlet")
    //Call<DataMovies> getDataMovies(@Query("ACTION") String action);

}
