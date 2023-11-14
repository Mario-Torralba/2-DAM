package com.example.vinted.nuevoProducto.data;

import com.google.gson.annotations.SerializedName;

public class MyData {

    @SerializedName("message")
    private String message;


    public String getMessage() {
        return message;
    }

}
