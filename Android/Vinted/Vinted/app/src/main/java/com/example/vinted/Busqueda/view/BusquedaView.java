package com.example.vinted.Busqueda.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.Busqueda.ContractBusqueda;
import com.example.vinted.Busqueda.data.Producto;
import com.example.vinted.Busqueda.presenter.BusquedaPresenter;
import com.example.vinted.Busqueda.view.RecyclerViewBusqueda.RecyclerViewAdapter;
import com.example.vinted.Busqueda.view.RecyclerViewBusqueda.Recyclerview_list;
import com.example.vinted.MainActivity;
import com.example.vinted.Mensajes.view.MensajesView;
import com.example.vinted.Perfil.view.PerfilView;
import com.example.vinted.R;
import com.example.vinted.mostrarTopVendedores.Data.Usuario;
import com.example.vinted.mostrarTopVendedores.view.RecyclerView.Recyclerview_adapter;
import com.example.vinted.mostrarTopVendedores.view.RecyclerView.recyclerview_list;
import com.example.vinted.nuevoProducto.view.NuevoView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;


public class BusquedaView extends AppCompatActivity implements ContractBusqueda.View {

    String categoria;
    String color;
    TextInputEditText busqueda;

    RecyclerView recyclerView;
    ArrayList<Recyclerview_list> recyclerviewList;

    BusquedaPresenter presenter = new BusquedaPresenter(this);

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
        setContentView(R.layout.activity_busqueda);
        initComponents();
    }
    private void initComponents(){

        this.busqueda = findViewById(R.id.inputBusqueda);

        Spinner spinner = findViewById(R.id.spinnerCategoria);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_categoría, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner2 = findViewById(R.id.spinnerColor);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.spinner_color, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoria = parent.getItemAtPosition(position).toString();
                presenter.hacerBusquedaPresenter(categoria,color,busqueda.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                color = parent.getItemAtPosition(position).toString();
                presenter.hacerBusquedaPresenter(categoria,color,busqueda.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        busqueda.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.hacerBusquedaPresenter(categoria,color,busqueda.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        this.home = findViewById(R.id.home);
        this.buscar = findViewById(R.id.buscar);
        this.crear = findViewById(R.id.crear);
        this.mensajes = findViewById(R.id.mensajes);
        this.perfil = findViewById(R.id.perfil);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusquedaView.this, MainActivity.class);
                startActivity(intent);
            }
        });

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusquedaView.this, NuevoView.class);
                startActivity(intent);
            }
        });

        mensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusquedaView.this, MensajesView.class);
                startActivity(intent);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusquedaView.this, PerfilView.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void successBusqueda(ArrayList<Producto> lstProducto) {

        recyclerView = findViewById(R.id.recyclerViewProductos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        recyclerviewList = new ArrayList<>();

        for (Producto e: lstProducto) {
            recyclerviewList.add(new Recyclerview_list(R.drawable.pepo,e.getNombre_producto(),e.getPrecio_producto() + " €"));
        }

        RecyclerViewAdapter recyclerviewAdapter = new RecyclerViewAdapter(recyclerviewList,this);
        recyclerView.setAdapter(recyclerviewAdapter);
    }

    @Override
    public void failureBusqueda(String err) {

    }
}
