package com.example.vinted.Perfil.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.Busqueda.view.BusquedaView;
import com.example.vinted.MainActivity;
import com.example.vinted.Mensajes.view.MensajesView;
import com.example.vinted.Perfil.ContractPerfil;
import com.example.vinted.R;
import com.example.vinted.nuevoProducto.view.NuevoView;


public class PerfilView extends AppCompatActivity implements ContractPerfil.View {

    Context contexto;
    LinearLayout home;
    LinearLayout buscar;
    LinearLayout crear;
    LinearLayout mensajes;
    LinearLayout perfil;
//    private NuevoPresenter nuevoPresenter = new NuevoPresenter(this);

    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        initComponents();
    }
    private void initComponents(){
        this.home = findViewById(R.id.home);
        this.buscar = findViewById(R.id.buscar);
        this.crear = findViewById(R.id.crear);
        this.mensajes = findViewById(R.id.mensajes);
        this.perfil = findViewById(R.id.perfil);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilView.this, BusquedaView.class);
                startActivity(intent);
            }
        });

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilView.this, NuevoView.class);
                startActivity(intent);
            }
        });

        mensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilView.this, MensajesView.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilView.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void successPerfil(String String) {

    }

    @Override
    public void failurePerfil(String err) {

    }
}
