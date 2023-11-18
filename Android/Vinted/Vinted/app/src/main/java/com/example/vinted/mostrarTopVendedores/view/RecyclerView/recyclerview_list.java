package com.example.vinted.mostrarTopVendedores.view.RecyclerView;

public class recyclerview_list {

    int image;
    String nombre_apellidos;
    String email;
    String telefono;
    String ventas;

    public recyclerview_list(int image, String nombre_apellidos, String email, String telefono, String ventas) {
        this.image = image;
        this.nombre_apellidos = nombre_apellidos;
        this.email = email;
        this.telefono = telefono;
        this.ventas = ventas;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }
}
