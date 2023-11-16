package com.example.vinted.Beans;

import java.util.ArrayList;

public class Producto {

    @Override
    public String toString() {
        return "Producto{" +
                "idUsuario=" + idUsuario +
                ", idEstado=" + idEstado +
                ", lstCategorias=" + lstCategorias +
                ", lstCategoriasString=" + lstCategoriasString +
                ", lstColores=" + lstColores +
                ", lstColoresString=" + lstColoresString +
                ", img='" + img + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", marca='" + marca + '\'' +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                '}';
    }

    private int idUsuario = 1;
    private int idEstado;

    private ArrayList<Integer> lstCategorias = new ArrayList<>();
    private ArrayList<String> lstCategoriasString = new ArrayList<>();

    private ArrayList<Integer> lstColores = new ArrayList<>();
    private ArrayList<String> lstColoresString = new ArrayList<>();

    private String img;
    private String titulo;
    private String descripcion;
    private String marca;
    private String estado;
    private int precio;

    public ArrayList<Integer> getLstColores() {
        return lstColores;
    }

    public void setLstColores(ArrayList<Integer> lstColores) {
        this.lstColores = lstColores;
    }

    public ArrayList<String> getLstColoresString() {
        return lstColoresString;
    }

    public void setLstColoresString(ArrayList<String> lstColoresString) {
        this.lstColoresString = lstColoresString;
    }

    public ArrayList<String> getLstCategoriasString() {
        return lstCategoriasString;
    }

    public void setLstCategoriasString(ArrayList<String> lstCategoriasString) {
        this.lstCategoriasString = lstCategoriasString;
    }

    public ArrayList<Integer> getLstCategorias() {
        return lstCategorias;
    }

    public void setLstCategorias(ArrayList<Integer> lstCategorias) {
        this.lstCategorias = lstCategorias;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
