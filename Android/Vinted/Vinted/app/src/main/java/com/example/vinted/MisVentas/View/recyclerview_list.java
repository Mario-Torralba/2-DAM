package com.example.vinted.MisVentas.View;

public class recyclerview_list {

    int image;
    String titulo;

    public recyclerview_list(int image, String titulo) {
        this.image = image;
        this.titulo = titulo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
