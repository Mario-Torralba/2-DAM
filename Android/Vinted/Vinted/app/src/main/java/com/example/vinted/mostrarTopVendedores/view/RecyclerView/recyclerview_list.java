package com.example.vinted.mostrarTopVendedores.view.RecyclerView;

public class recyclerview_list {

    int image;
    String nombre_apellidos;
    String email;
    String ventas;
    int vector;

    public int getVector() {
        return vector;
    }

    public void setVector(int vector) {
        this.vector = vector;
    }

    public recyclerview_list(int image, String nombre_apellidos, String email, String ventas, int vector) {
        this.image = image;
        this.nombre_apellidos = nombre_apellidos;
        this.email = email;
        this.ventas = ventas;
        this.vector = vector;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre_apellidos() {
        return nombre_apellidos;
    }

    public void setNombre_apellidos(String nombre_apellidos) {
        this.nombre_apellidos = nombre_apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }
}
