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
import java.util.Random;

public class MisVentasView extends AppCompatActivity implements ContractMisVentas.View {

    Context contexto;
    ArrayList<recyclerview_list> recyclerview_list;
    ArrayList<Producto> lstProductosBuena;
    RecyclerView recyclerView;
    private MisVentasPresenter presenter;

    Random rand = new Random();

    int[] imagenes = {
            R.drawable.calcetinesamarillos,
            R.drawable.calcetinesazules,
            R.drawable.calcetinesnegros,
            R.drawable.calcetinesrojos,
            R.drawable.calcetinesverdes,
            R.drawable.camisetaamarilla,
            R.drawable.camisetaazul,
            R.drawable.camisetanegra,
            R.drawable.camisetaroja,
            R.drawable.camisetaverde,
            R.drawable.pantalonesamarillos,
            R.drawable.pantalonesazules,
            R.drawable.pantalonesnegros,
            R.drawable.pantalonesrojos,
            R.drawable.pantalonesverdes,
            R.drawable.sudaderaamarilla,
            R.drawable.sudaderaazul,
            R.drawable.sudaderanegra,
            R.drawable.sudaderaroja,
            R.drawable.sudaderaverde,
            R.drawable.zapatillasamarillas,
            R.drawable.zapatillasazules,
            R.drawable.zapatillasnegras,
            R.drawable.zapatillasrojas,
            R.drawable.zapatillasverdes
    };

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
            recyclerview_list.add(new recyclerview_list(imagenes[rand.nextInt(25)],e.getNombreProducto()));
        }
        recyclerview_adapter recyclerviewAdapter = new recyclerview_adapter(recyclerview_list,this);
        recyclerView.setAdapter(recyclerviewAdapter);
    }

    @Override
    public void failureVerMisVentasView(String err) {

    }
}
