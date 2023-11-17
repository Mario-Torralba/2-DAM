package com.example.vinted.MisVentas.Data;

public class Producto {

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto=" + id_producto +
                ", id_usuario=" + id_usuario +
                ", id_estado=" + id_estado +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", marcaProducto='" + marcaProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", imagenProducto='" + imagenProducto + '\'' +
                '}';
    }

    private int id_producto;
    private int id_usuario;
    private int id_estado;
    private String nombreProducto;
    private String descripcionProducto;
    private String marcaProducto;
    private int precioProducto;
    private String imagenProducto;

    public Producto(){}

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
}
