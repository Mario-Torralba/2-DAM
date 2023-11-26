package com.example.vinted.MisCompras.View;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.MisCompras.Data.MisProductosData;
import com.example.vinted.MisCompras.Data.Producto;
import com.example.vinted.MisCompras.MisComprasContract;
import com.example.vinted.MisCompras.Presenter.MisComprasPresenter;
import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.AdapterMisCompras;
import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.RecyclerView_list_mis_compras;
import com.example.vinted.MisVentas.View.recyclerview_adapter;
import com.example.vinted.MisVentas.View.recyclerview_list;
import com.example.vinted.R;

import java.util.ArrayList;

public class MisComprasView extends AppCompatActivity implements MisComprasContract.View {

    MisComprasPresenter presenter = new MisComprasPresenter(this);

    Context contexto;

    RecyclerView recyclerView;
    ArrayList<RecyclerView_list_mis_compras> recyclerview_list;

    public void onCreate(Bundle savedInstanceState) {
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mis_compras_activity);
        initComponents();
    }
    public void initComponents(){
        presenter.verMisComprasPresenter(1);
    }

    @Override
    public void successVerMisComprasView(MisProductosData productos) {

        recyclerView = findViewById(R.id.recyclerViewMisCompras);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerview_list = new ArrayList<>();

        for (Producto e: productos.getLstProductos()) {
            recyclerview_list.add(new RecyclerView_list_mis_compras(R.drawable.risitas,e.getNombreProducto()));
        }
        AdapterMisCompras recyclerviewAdapter = new AdapterMisCompras(recyclerview_list,this);
        recyclerView.setAdapter(recyclerviewAdapter);
    }

    @Override
    public void failureVerMisComprasView(String err) {

    }
}
