package com.example.vinted.CaracteristicasProducto.Data;

import java.util.ArrayList;

public class DataProductoRelacionado {

    String message;
    ArrayList<ProductoRelacionado> lstProductosRelacionados = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ProductoRelacionado> getLstProductosRelacionados() {
        return lstProductosRelacionados;
    }

    public void setLstProductosRelacionados(ArrayList<ProductoRelacionado> lstProductosRelacionados) {
        this.lstProductosRelacionados = lstProductosRelacionados;
    }
}
