package com.example.vinted.mostrarTopVendedores.Data;

import java.util.ArrayList;

public class DataUsuarios {

    private String message;
    ArrayList<Usuario> lstUsuarios = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(ArrayList<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
}
