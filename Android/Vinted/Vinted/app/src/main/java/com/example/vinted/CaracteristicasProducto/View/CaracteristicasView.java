package com.example.vinted.CaracteristicasProducto.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.Busqueda.data.Producto;
import com.example.vinted.Busqueda.view.RecyclerViewBusqueda.RecyclerViewAdapter;
import com.example.vinted.Busqueda.view.RecyclerViewBusqueda.Recyclerview_list;
import com.example.vinted.CaracteristicasProducto.ContractCaracteristicasProducto;
import com.example.vinted.CaracteristicasProducto.Data.DataProductoRelacionado;
import com.example.vinted.CaracteristicasProducto.Data.ProductoCaracteristicas;
import com.example.vinted.CaracteristicasProducto.Data.ProductoRelacionado;
import com.example.vinted.CaracteristicasProducto.Presenter.CaracteristicasPresenter;
import com.example.vinted.CaracteristicasProducto.View.RecyclerViewCaracteristicas.RecyclerViewAdapterCaracteristicas;
import com.example.vinted.CaracteristicasProducto.View.RecyclerViewCaracteristicas.RecyclerViewListCaracteristicas;
import com.example.vinted.MisVentas.Presenter.MisVentasPresenter;
import com.example.vinted.R;

import java.util.ArrayList;

public class CaracteristicasView extends AppCompatActivity implements ContractCaracteristicasProducto.View {

    RecyclerView recyclerViewCaracteristicas;
    ArrayList<RecyclerViewListCaracteristicas> recyclerViewListCaracteristicas;

    Context contexto;
    CaracteristicasPresenter presenter = new CaracteristicasPresenter(this);

    TextView nombreUsuario;
    TextView cantidadValoraciones;
    ImageView estrella1;
    ImageView estrella2;
    ImageView estrella3;
    ImageView estrella4;
    ImageView estrella5;

    TextView nombreProducto;
    TextView estadoProducto;
    TextView precioProducto;
    TextView precioProducto2;
    TextView coloresProducto;
    TextView descripcionProducto;
    TextView productosRelacionados;

    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas);
        initComponents();
    }

    public void initComponents(){

        this.nombreUsuario = findViewById(R.id.nombreUsuario);
        this.estrella1 = findViewById(R.id.estrella1);
        this.estrella2 = findViewById(R.id.estrella2);
        this.estrella3 = findViewById(R.id.estrella3);
        this.estrella4 = findViewById(R.id.estrella4);
        this.estrella5 = findViewById(R.id.estrella5);
        this.nombreProducto = findViewById(R.id.nombreProducto);
        this.estadoProducto = findViewById(R.id.estadoProducto);
        this.precioProducto = findViewById(R.id.precioProducto);
        this.precioProducto2 = findViewById(R.id.precioProducto2);
        this.coloresProducto = findViewById(R.id.coloresProducto);
        this.descripcionProducto = findViewById(R.id.descripcionProducto);
        this.productosRelacionados = findViewById(R.id.productosRelacionados);


        String nombre = getIntent().getStringExtra("nombreProducto");
        presenter.caracteristicasProductoPresenter(nombre);




    }

    @SuppressLint("SetTextI18n")
    @Override
    public void successCaracteristicas(ProductoCaracteristicas producto) {
        System.out.println(producto.toString());

        nombreUsuario.setText(producto.getNombre_apellidos());
        this.cantidadValoraciones = findViewById(R.id.cantidadValoraciones);
        cantidadValoraciones.setText("(" + producto.getCantidad_estrellas() +")");


        if(producto.getEstrellas()==1){
            estrella1.setImageResource(R.drawable.estrella_llena);
        }
        if(producto.getEstrellas()==2){
            estrella1.setImageResource(R.drawable.estrella_llena);
            estrella2.setImageResource(R.drawable.estrella_llena);
        }
        if(producto.getEstrellas()==3){
            estrella1.setImageResource(R.drawable.estrella_llena);
            estrella2.setImageResource(R.drawable.estrella_llena);
            estrella3.setImageResource(R.drawable.estrella_llena);
        }
        if(producto.getEstrellas()==4){
            estrella1.setImageResource(R.drawable.estrella_llena);
            estrella2.setImageResource(R.drawable.estrella_llena);
            estrella3.setImageResource(R.drawable.estrella_llena);
            estrella4.setImageResource(R.drawable.estrella_llena);
        }
        if(producto.getEstrellas()==5){
            estrella1.setImageResource(R.drawable.estrella_llena);
            estrella2.setImageResource(R.drawable.estrella_llena);
            estrella3.setImageResource(R.drawable.estrella_llena);
            estrella4.setImageResource(R.drawable.estrella_llena);
            estrella5.setImageResource(R.drawable.estrella_llena);
        }

        nombreProducto.setText(producto.getNombre_producto());
        estadoProducto.setText(producto.getEstado_producto());
        precioProducto.setText(producto.getPrecio_producto() + " €");
        precioProducto2.setText((producto.getPrecio_producto() * 1.10) + " € Protección al comprador incluida");
        coloresProducto.setText(producto.getColores_producto());
        descripcionProducto.setText(producto.getDescripcion_producto());
        productosRelacionados.setText("Más productos de " + producto.getNombre_apellidos());

        presenter.productosRelacionadosPresenter(producto.getId_usuario_vendedor());


    }

    @Override
    public void successProductosRelacionados(DataProductoRelacionado data) {

        recyclerViewCaracteristicas = findViewById(R.id.recyclerviewProductosRelacionados);
        recyclerViewCaracteristicas.setHasFixedSize(true);
        recyclerViewCaracteristicas.setLayoutManager(new GridLayoutManager(this,1));

        recyclerViewListCaracteristicas = new ArrayList<>();

        for (ProductoRelacionado e: data.getLstProductosRelacionados()) {
            recyclerViewListCaracteristicas.add(new RecyclerViewListCaracteristicas(R.drawable.pepo,e.getNombreProducto(), e.getPrecio() + " €"));
        }

        RecyclerViewAdapterCaracteristicas recyclerviewAdapter = new RecyclerViewAdapterCaracteristicas(recyclerViewListCaracteristicas,this);
        recyclerViewCaracteristicas.setAdapter(recyclerviewAdapter);

    }

    @Override
    public void failureBusqueda(String err) {

    }
}
