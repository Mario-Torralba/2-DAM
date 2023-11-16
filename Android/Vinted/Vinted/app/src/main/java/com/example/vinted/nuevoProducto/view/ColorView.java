package com.example.vinted.nuevoProducto.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.Beans.Producto;
import com.example.vinted.R;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;

public class ColorView extends AppCompatActivity implements ContractNuevoProducto.View {


    Context contexto;
    LinearLayout botonColor;

    CheckBox negro;
    CheckBox blanco;
    CheckBox azul;
    CheckBox rojo;
    CheckBox verde;
    CheckBox amarillo;
    CheckBox naranja;
    CheckBox morado;

    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        initComponents();
    }

    public void initComponents(){

        botonColor = findViewById(R.id.botonColor);
        negro = findViewById(R.id.negro);
        blanco = findViewById(R.id.blanco);
        azul = findViewById(R.id.azul);
        rojo = findViewById(R.id.rojo);
        verde = findViewById(R.id.verde);
        amarillo = findViewById(R.id.amarillo);
        naranja = findViewById(R.id.naranja);
        morado = findViewById(R.id.morado);

        botonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(negro.isChecked()){
                    NuevoView.producto.getLstColores().add(1);
                    NuevoView.producto.getLstColoresString().add("Negro");
                }
                if(blanco.isChecked()){
                    NuevoView.producto.getLstColores().add(2);
                    NuevoView.producto.getLstColoresString().add("Blanco");
                }
                if(azul.isChecked()){
                    NuevoView.producto.getLstColores().add(3);
                    NuevoView.producto.getLstColoresString().add("Azul");
                }
                if(rojo.isChecked()){
                    NuevoView.producto.getLstColores().add(4);
                    NuevoView.producto.getLstColoresString().add("Rojo");
                }
                if(verde.isChecked()){
                    NuevoView.producto.getLstColores().add(5);
                    NuevoView.producto.getLstColoresString().add("Verde");
                }
                if(amarillo.isChecked()){
                    NuevoView.producto.getLstColores().add(6);
                    NuevoView.producto.getLstColoresString().add("Amarillo");
                }
                if(naranja.isChecked()){
                    NuevoView.producto.getLstColores().add(7);
                    NuevoView.producto.getLstColoresString().add("Naranja");
                }
                if(morado.isChecked()){
                    NuevoView.producto.getLstColores().add(8);
                    NuevoView.producto.getLstColoresString().add("Morado");
                }

                System.out.println(NuevoView.producto.toString());

                Intent intent = new Intent(ColorView.this, NuevoView.class);
                finish();
                startActivity(intent);
            }
        });
    }


    @Override
    public void successCrearProductoView(String String) {

    }

    @Override
    public void failureCrearProductoView(String err) {

    }

    @Override
    public void successAsociarCategoriasView(String String) {

    }

    @Override
    public void failureAsociarCategoriasView(String err) {

    }

    @Override
    public void successAsociarColoresView(String String) {

    }

    @Override
    public void failureAsociarColoresView(String err) {

    }
}
