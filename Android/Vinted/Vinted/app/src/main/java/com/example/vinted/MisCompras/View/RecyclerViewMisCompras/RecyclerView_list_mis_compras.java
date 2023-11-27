package com.example.vinted.MisCompras.View.RecyclerViewMisCompras;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.MisCompras.Data.Producto;
import com.example.vinted.R;

public class RecyclerView_list_mis_compras {


    int image;
    String titulo;

    Producto producto;

    public RecyclerView_list_mis_compras(int image, String titulo, Producto producto) {
        this.image = image;
        this.titulo = titulo;
        this.producto = producto;
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
