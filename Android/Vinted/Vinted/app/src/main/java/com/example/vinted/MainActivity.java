package com.example.vinted;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vinted.Busqueda.view.BusquedaView;
import com.example.vinted.Login.view.LoginView;
import com.example.vinted.Login.view.RecyclerView.Recyclerview_adapter;
import com.example.vinted.Login.view.RecyclerView.recyclerview_list;
import com.example.vinted.Mensajes.view.MensajesView;
import com.example.vinted.MisVentas.View.recyclerview_adapter;
import com.example.vinted.Perfil.view.PerfilView;
import com.example.vinted.nuevoProducto.view.NuevoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<com.example.vinted.Login.view.RecyclerView.recyclerview_list> recyclerview_list;
    RecyclerView recyclerView;
    private static final long SPLASH_DISPLAY_LENGTH = 3000;
    Context contexto;
    LinearLayout home;
    LinearLayout buscar;
    LinearLayout crear;
    LinearLayout mensajes;
    LinearLayout perfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.contexto = this;
        initComponents();
    }

    private void initComponents(){

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));

        recyclerview_list = new ArrayList<>();

        recyclerview_list.add(new recyclerview_list(R.drawable.risitas,"Mario Torralba Pardos", "a26807@svalero.com","9767214687","Ventas : 5"));
        recyclerview_list.add(new recyclerview_list(R.drawable.risitas,"Mario Torralba Pardos", "a26807@svalero.com","9767214687","Ventas : 5"));
        recyclerview_list.add(new recyclerview_list(R.drawable.risitas,"Mario Torralba Pardos", "a26807@svalero.com","9767214687","Ventas : 5"));
        recyclerview_list.add(new recyclerview_list(R.drawable.risitas,"Mario Torralba Pardos", "a26807@svalero.com","9767214687","Ventas : 5"));
        recyclerview_list.add(new recyclerview_list(R.drawable.risitas,"Mario Torralba Pardos", "a26807@svalero.com","9767214687","Ventas : 5"));

        Recyclerview_adapter recyclerviewAdapter = new Recyclerview_adapter(recyclerview_list,this);
        recyclerView.setAdapter(recyclerviewAdapter);


        this.home = findViewById(R.id.home);
        this.buscar = findViewById(R.id.buscar);
        this.crear = findViewById(R.id.crear);
        this.mensajes = findViewById(R.id.mensajes);
        this.perfil = findViewById(R.id.perfil);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BusquedaView.class);
                startActivity(intent);
            }
        });

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NuevoView.class);
                startActivity(intent);
            }
        });

        mensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MensajesView.class);
                startActivity(intent);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PerfilView.class);
                startActivity(intent);
            }
        });
    }

}