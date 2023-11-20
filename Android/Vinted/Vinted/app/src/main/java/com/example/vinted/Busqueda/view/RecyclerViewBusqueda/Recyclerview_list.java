package com.example.vinted.Busqueda.view.RecyclerViewBusqueda;

public class Recyclerview_list {

    int image;
    String nombreProducto;
    String precio;

    public Recyclerview_list(int image, String nombreProducto, String precio) {
        this.image = image;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
