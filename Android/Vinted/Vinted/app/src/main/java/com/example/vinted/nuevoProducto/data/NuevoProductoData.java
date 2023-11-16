package com.example.vinted.nuevoProducto.data;

import com.google.gson.annotations.SerializedName;

public class NuevoProductoData {
    @Override
    public String toString() {
        return "NuevoProductoData{" +
                "message='" + message + '\'' +
                '}';
    }

    @SerializedName("message")
    private String message;


    public String getMessage() {
        return message;
    }

}
