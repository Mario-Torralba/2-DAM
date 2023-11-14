package com.example.vinted.Mensajes.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.Busqueda.view.BusquedaView;
import com.example.vinted.MainActivity;
import com.example.vinted.Mensajes.ContractMensajes;
import com.example.vinted.Perfil.view.PerfilView;
import com.example.vinted.R;
import com.example.vinted.nuevoProducto.view.NuevoView;


public class MensajesView extends AppCompatActivity implements ContractMensajes.View {

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
        setContentView(R.layout.activity_mensaje);
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
                Intent intent = new Intent(MensajesView.this, BusquedaView.class);
                startActivity(intent);
            }
        });

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MensajesView.this, NuevoView.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MensajesView.this, MainActivity.class);
                startActivity(intent);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MensajesView.this, PerfilView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void successMensaje(String String) {

    }

    @Override
    public void failureMensaje(String err) {

    }
}
