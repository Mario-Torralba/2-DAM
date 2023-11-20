package com.example.vinted;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.vinted.Busqueda.view.BusquedaView;
import com.example.vinted.MostrarTopValoraciones.ContractMostrarTopValoraciones;
import com.example.vinted.MostrarTopValoraciones.Data.UsuarioValoraciones;
import com.example.vinted.MostrarTopValoraciones.Presenter.MostrarValoracionesPresenter;
import com.example.vinted.mostrarTopVendedores.ContractMostrarTopVendedores;
import com.example.vinted.mostrarTopVendedores.Data.Usuario;
import com.example.vinted.mostrarTopVendedores.presenter.MostrarTopVendedoresPresenter;
import com.example.vinted.mostrarTopVendedores.view.RecyclerView.Recyclerview_adapter;
import com.example.vinted.mostrarTopVendedores.view.RecyclerView.recyclerview_list;
import com.example.vinted.Mensajes.view.MensajesView;
import com.example.vinted.Perfil.view.PerfilView;
import com.example.vinted.nuevoProducto.view.NuevoView;

import java.util.ArrayList;

//Valorar en qué momento debemos pedir registro o login al Usuario.
//        Usuario – Vendedor:
//        1. Dar de alta productos, imagen, descripción, precio, etc. por
//        usuario.
//        2. Listado de mis productos a la venta como usuario
//        Usuario – Cliente:
//        3. Listado de los 10 propietarios con más ventas.
//        4. Puntuar una prenda concreta
//        5. Listado de los 10 productos más puntuados.
//        6. Filtrado en función de las necesidades del usuario (Mujer,
//        Hombre, niños, o las categorías que estiméis oportunas).
//        7. Filtrado en función de la palabra escrita por el usuario.
//        8. Ver ficha descriptiva de la prenda y sus características.
//        9. Confirmar compra.
//        10. Histórico de compras.

public class MainActivity extends AppCompatActivity implements ContractMostrarTopVendedores.View, ContractMostrarTopValoraciones.View {

    MostrarTopVendedoresPresenter presenter = new MostrarTopVendedoresPresenter(this);
    MostrarValoracionesPresenter presenter2 = new MostrarValoracionesPresenter(this);

    ArrayList<com.example.vinted.mostrarTopVendedores.view.RecyclerView.recyclerview_list> recyclerview_list;
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
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

        presenter.verMisVentasPresenter();
        presenter2.verTopValoracionesPresenter();


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

    @Override
    public void successVerMisVentasView(ArrayList<Usuario> lstUsuarios) {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,lstUsuarios.size()));

        recyclerview_list = new ArrayList<>();

        for (Usuario e:lstUsuarios) {
            recyclerview_list.add(new recyclerview_list(R.drawable.goku_meme,e.getNombre_apellidos(), e.getEmail(),e.getTelefono(),"Ventas : " + e.getVentas()));
        }

        Recyclerview_adapter recyclerviewAdapter = new Recyclerview_adapter(recyclerview_list,this);
        recyclerView.setAdapter(recyclerviewAdapter);

    }

    @Override
    public void failureVerMisVentasView(String err) {

    }

    @Override
    public void successVerTopValoracionesView(ArrayList<UsuarioValoraciones> lstUsuarios) {

        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new GridLayoutManager(this,lstUsuarios.size()));

        recyclerview_list = new ArrayList<>();

        for (UsuarioValoraciones e:lstUsuarios) {
            recyclerview_list.add(new recyclerview_list(R.drawable.dejava,e.getNombre_apellidos(), e.getEmail(),e.getTelefono(),"Valoracion : " + e.getEstrellas()));
        }

        Recyclerview_adapter recyclerviewAdapter = new Recyclerview_adapter(recyclerview_list,this);
        recyclerView2.setAdapter(recyclerviewAdapter);
    }

    @Override
    public void failureVerTopValoracionesView(String err) {

    }
}