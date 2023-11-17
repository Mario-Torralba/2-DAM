package com.example.vinted.MisVentas.View;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.MisVentas.ContractMisVentas;
import com.example.vinted.MisVentas.Data.Producto;
import com.example.vinted.MisVentas.Presenter.MisVentasPresenter;
import com.example.vinted.Perfil.ContractPerfil;
import com.example.vinted.R;

import java.util.ArrayList;

public class MisVentasView extends AppCompatActivity implements ContractMisVentas.View {

    Context contexto;
    ArrayList<recyclerview_list> recyclerview_list;
    ArrayList<Producto> lstProductosBuena;
    RecyclerView recyclerView;
    private MisVentasPresenter presenter;

    protected void onCreate(Bundle savedInstanceState){
        presenter = new MisVentasPresenter(this);
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misventas);
        initComponents();
    }

    public void initComponents(){

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerview_list = new ArrayList<recyclerview_list>();



        presenter.verMisVentasPresenter(1);


    }

    @Override
    public void successVerMisVentasView(ArrayList<com.example.vinted.MisVentas.Data.Producto> lstProductos) {
        Toast.makeText(contexto,"MOSTRADOS",Toast.LENGTH_SHORT).show();
        System.out.println(lstProductos.toString());
        for (Producto e: lstProductos) {
            recyclerview_list.add(new recyclerview_list(R.drawable.risitas,e.getNombreProducto()));
        }
        recyclerview_adapter recyclerviewAdapter = new recyclerview_adapter(recyclerview_list,this);
        recyclerView.setAdapter(recyclerviewAdapter);
    }

    @Override
    public void failureVerMisVentasView(String err) {

    }
}
