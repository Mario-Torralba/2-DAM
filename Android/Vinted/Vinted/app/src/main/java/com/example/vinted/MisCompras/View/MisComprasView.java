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
import java.util.Random;

public class MisComprasView extends AppCompatActivity implements MisComprasContract.View {

    MisComprasPresenter presenter = new MisComprasPresenter(this);

    Context contexto;

    RecyclerView recyclerView;
    ArrayList<RecyclerView_list_mis_compras> recyclerview_list;

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
            recyclerview_list.add(new RecyclerView_list_mis_compras(imagenes[rand.nextInt(25)],e.getNombreProducto(), e));
        }
        AdapterMisCompras recyclerviewAdapter = new AdapterMisCompras(recyclerview_list,this);
        recyclerView.setAdapter(recyclerviewAdapter);
    }

    @Override
    public void failureVerMisComprasView(String err) {

    }
}
