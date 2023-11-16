package com.example.vinted.nuevoProducto.view;


import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.R;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;

public class EstadoView extends AppCompatActivity implements ContractNuevoProducto.View {

    Context contexto;
    public static String estadoFinal;
    LinearLayout botonEnviar;

    LinearLayout nuevoCon;
    LinearLayout nuevoSin;
    LinearLayout bueno;
    LinearLayout muyBueno;
    LinearLayout satisfactorio;

    TextView nuevoConTexto;
    TextView nuevoSinTexto;
    TextView buenoTexto;
    TextView muyBuenoTexto;
    TextView satisfactorioTexto;

    ImageView nuevoConImagen;
    ImageView nuevoSinImagen;
    ImageView buenoImagen;
    ImageView muyBuenoImagen;
    ImageView satisfactorioImagen;


    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado);
        initComponents();
    }
    public void initComponents(){

        this.botonEnviar = findViewById(R.id.botonEnviar);

        this.nuevoCon = findViewById(R.id.nuevoCon);
        this.nuevoSin = findViewById(R.id.nuevoSin);
        this.bueno = findViewById(R.id.bueno);
        this.muyBueno = findViewById(R.id.muyBueno);
        this.satisfactorio = findViewById(R.id.satisfactorio);

        this.nuevoConImagen = findViewById(R.id.nuevoConImagen);
        this.nuevoSinImagen = findViewById(R.id.nuevoSinImagen);
        this.buenoImagen = findViewById(R.id.buenoImagen);
        this.muyBuenoImagen = findViewById(R.id.muyBuenoImagen);
        this.satisfactorioImagen = findViewById(R.id.satisfactorioImagen);

        this.nuevoConTexto = findViewById(R.id.nuevoConTexto);
        this.nuevoSinTexto = findViewById(R.id.nuevoSinTexto);
        this.buenoTexto = findViewById(R.id.buenoTexto);
        this.muyBuenoTexto = findViewById(R.id.muyBuenoTexto);
        this.satisfactorioTexto = findViewById(R.id.satisfactorioTexto);

        nuevoCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                todosCruz();
                nuevoConImagen.setImageResource(R.drawable.baseline_check_24);
                nuevoConImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                nuevoCon.setBackgroundColor(getResources().getColor(R.color.vinted));
                nuevoConTexto.setTextColor(getResources().getColor(R.color.white));
                estadoFinal = (String)nuevoConTexto.getText();
            }
        });

        nuevoSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                todosCruz();
                nuevoSinImagen.setImageResource(R.drawable.baseline_check_24);
                nuevoSinImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                nuevoSin.setBackgroundColor(getResources().getColor(R.color.vinted));
                nuevoSinTexto.setTextColor(getResources().getColor(R.color.white));
                estadoFinal = (String)nuevoSinTexto.getText();
            }
        });

        bueno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                todosCruz();
                buenoImagen.setImageResource(R.drawable.baseline_check_24);
                buenoImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                bueno.setBackgroundColor(getResources().getColor(R.color.vinted));
                buenoTexto.setTextColor(getResources().getColor(R.color.white));
                estadoFinal = (String)buenoTexto.getText();
            }
        });

        muyBueno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                todosCruz();
                muyBuenoImagen.setImageResource(R.drawable.baseline_check_24);
                muyBuenoImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                muyBueno.setBackgroundColor(getResources().getColor(R.color.vinted));
                muyBuenoTexto.setTextColor(getResources().getColor(R.color.white));
                estadoFinal = (String)muyBuenoTexto.getText();
            }
        });
        satisfactorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                todosCruz();
                satisfactorioImagen.setImageResource(R.drawable.baseline_check_24);
                satisfactorioImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
                satisfactorio.setBackgroundColor(getResources().getColor(R.color.vinted));
                satisfactorioTexto.setTextColor(getResources().getColor(R.color.white));
                estadoFinal = (String)satisfactorioTexto.getText();
            }
        });

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(estadoFinal==null){
                    Toast.makeText(contexto,"Selecciona un estado para tu producto",Toast.LENGTH_SHORT).show();
                }else{
                    NuevoView.producto.setEstado(estadoFinal);
                    Intent intent = new Intent(EstadoView.this, NuevoView.class);
                    finish();
                    startActivity(intent);
                }
            }
        });



    }

    public void todosCruz(){

        nuevoConImagen.setImageResource(R.drawable.baseline_close_24);
        nuevoSinImagen.setImageResource(R.drawable.baseline_close_24);
        buenoImagen.setImageResource(R.drawable.baseline_close_24);
        muyBuenoImagen.setImageResource(R.drawable.baseline_close_24);
        satisfactorioImagen.setImageResource(R.drawable.baseline_close_24);

        nuevoConImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
        nuevoSinImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
        buenoImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
        muyBuenoImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
        satisfactorioImagen.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));

        nuevoCon.setBackgroundColor(getResources().getColor(R.color.white));
        nuevoSin.setBackgroundColor(getResources().getColor(R.color.white));
        bueno.setBackgroundColor(getResources().getColor(R.color.white));
        muyBueno.setBackgroundColor(getResources().getColor(R.color.white));
        satisfactorio.setBackgroundColor(getResources().getColor(R.color.white));

        nuevoConTexto.setTextColor(getResources().getColor(R.color.black));
        nuevoSinTexto.setTextColor(getResources().getColor(R.color.black));
        buenoTexto.setTextColor(getResources().getColor(R.color.black));
        muyBuenoTexto.setTextColor(getResources().getColor(R.color.black));
        satisfactorioTexto.setTextColor(getResources().getColor(R.color.black));
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
