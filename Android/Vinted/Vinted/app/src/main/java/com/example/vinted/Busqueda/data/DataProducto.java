package com.example.vinted.Busqueda.data;

import java.util.ArrayList;

public class DataProducto {

    String message;
    ArrayList<Producto> lstProducto = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(ArrayList<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }
}
