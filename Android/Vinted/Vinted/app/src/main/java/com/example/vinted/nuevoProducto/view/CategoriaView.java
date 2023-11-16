package com.example.vinted.nuevoProducto.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.Beans.Producto;
import com.example.vinted.R;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;

public class CategoriaView extends AppCompatActivity implements ContractNuevoProducto.View {

    Context contexto;
    LinearLayout botonCategoria;

    CheckBox hombre;
    CheckBox mujer;
    CheckBox niño;
    CheckBox niña;
    CheckBox verano;
    CheckBox invierno;
    CheckBox calzado;
    CheckBox ropa;

    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        initComponents();
    }

    public void initComponents(){

        botonCategoria = findViewById(R.id.botonCategoria);
        hombre = findViewById(R.id.hombre);
        mujer = findViewById(R.id.mujer);
        niño = findViewById(R.id.niño);
        niña = findViewById(R.id.niña);
        verano = findViewById(R.id.verano);
        invierno = findViewById(R.id.invierno);
        calzado = findViewById(R.id.calzado);
        ropa = findViewById(R.id.ropa);

        botonCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(hombre.isChecked()){
                    NuevoView.producto.getLstCategorias().add(1);
                    NuevoView.producto.getLstCategoriasString().add("Hombre");
                }
                if(mujer.isChecked()){
                    NuevoView.producto.getLstCategorias().add(2);
                    NuevoView.producto.getLstCategoriasString().add("Mujer");
                }
                if(niño.isChecked()){
                    NuevoView.producto.getLstCategorias().add(3);
                    NuevoView.producto.getLstCategoriasString().add("Niño");
                }
                if(niña.isChecked()){
                    NuevoView.producto.getLstCategorias().add(4);
                    NuevoView.producto.getLstCategoriasString().add("Niña");
                }
                if(invierno.isChecked()){
                    NuevoView.producto.getLstCategorias().add(5);
                    NuevoView.producto.getLstCategoriasString().add("Invierno");
                }
                if(verano.isChecked()){
                    NuevoView.producto.getLstCategorias().add(6);
                    NuevoView.producto.getLstCategoriasString().add("Verano");
                }
                if(ropa.isChecked()){
                    NuevoView.producto.getLstCategorias().add(7);
                    NuevoView.producto.getLstCategoriasString().add("Ropa");
                }
                if(calzado.isChecked()){
                    NuevoView.producto.getLstCategorias().add(8);
                    NuevoView.producto.getLstCategoriasString().add("Calzado");
                }

                System.out.println(NuevoView.producto.toString());

                Intent intent = new Intent(CategoriaView.this, NuevoView.class);
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
