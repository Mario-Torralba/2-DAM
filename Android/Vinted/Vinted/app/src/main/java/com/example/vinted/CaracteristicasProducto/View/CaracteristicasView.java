package com.example.vinted.CaracteristicasProducto.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.CaracteristicasProducto.ContractCaracteristicasProducto;
import com.example.vinted.CaracteristicasProducto.Data.DataProductoRelacionado;
import com.example.vinted.CaracteristicasProducto.Data.ProductoCaracteristicas;
import com.example.vinted.CaracteristicasProducto.Data.ProductoRelacionado;
import com.example.vinted.CaracteristicasProducto.Presenter.CaracteristicasPresenter;
import com.example.vinted.CaracteristicasProducto.View.RecyclerViewCaracteristicas.RecyclerViewAdapterCaracteristicas;
import com.example.vinted.CaracteristicasProducto.View.RecyclerViewCaracteristicas.RecyclerViewListCaracteristicas;
import com.example.vinted.MainActivity;
import com.example.vinted.R;

import java.util.ArrayList;
import java.util.Random;

public class CaracteristicasView extends AppCompatActivity implements ContractCaracteristicasProducto.View {

    RecyclerView recyclerViewCaracteristicas;
    ArrayList<RecyclerViewListCaracteristicas> recyclerViewListCaracteristicas;

    String nombre;
    int id_usuario_vendedor;
    int id_usuario_comprador = 1;

    LinearLayout pantallaCarga;
    ConstraintLayout padre;

    LinearLayout botonCompra;

    Intent intent;
    Context contexto;
    CaracteristicasPresenter presenter = new CaracteristicasPresenter(this);

    ImageView imagenProducto;
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
        this.pantallaCarga = findViewById(R.id.pantallaCarga);
        this.padre = findViewById(R.id.padre);
        this.botonCompra = findViewById(R.id.botonCompra);
        this.imagenProducto = findViewById(R.id.imagenProducto);


        String nombre = getIntent().getStringExtra("nombreProducto");
        presenter.caracteristicasProductoPresenter(nombre);

        botonCompra.setOnClickListener(e->{
            presenter.compraPresenter(nombre, id_usuario_vendedor, id_usuario_comprador);
        });


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void successCaracteristicas(ProductoCaracteristicas producto) {

        nombre = producto.getNombre_producto();
        id_usuario_vendedor = producto.getId_usuario_vendedor();
        id_usuario_comprador = producto.getId_usuario_comprador();

        imagenProducto.setImageResource(imagenes[rand.nextInt(25)]);

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
        recyclerViewCaracteristicas.setLayoutManager(new GridLayoutManager(this,2));

        recyclerViewListCaracteristicas = new ArrayList<>();

        for (ProductoRelacionado e: data.getLstProductosRelacionados()) {
            recyclerViewListCaracteristicas.add(new RecyclerViewListCaracteristicas(imagenes[rand.nextInt(25)] ,e.getNombreProducto(), e.getPrecio() + " €"));
        }

        RecyclerViewAdapterCaracteristicas recyclerviewAdapter = new RecyclerViewAdapterCaracteristicas(recyclerViewListCaracteristicas,this);
        recyclerViewCaracteristicas.setAdapter(recyclerviewAdapter);

        padre.removeView(pantallaCarga);

    }

    @Override
    public void successCompra(String resp) {
        Toast.makeText(contexto, resp, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(CaracteristicasView.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void failureBusqueda(String err) {

    }
}
