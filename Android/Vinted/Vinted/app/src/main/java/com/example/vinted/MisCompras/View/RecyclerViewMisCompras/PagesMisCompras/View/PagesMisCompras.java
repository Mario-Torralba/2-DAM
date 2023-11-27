package com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.View;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.Data.PagesMisComprasProducto;
import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.Presenter.PagesMisComprasPresenter;
import com.example.vinted.R;

public class PagesMisCompras extends AppCompatActivity implements ContractPagesMisCompras.View{

    Context contexto;
    String nombre;
    PagesMisComprasPresenter presenter = new PagesMisComprasPresenter(this);

    TextView nombreUsuario;
    TextView nombreProducto;
    TextView estadoProducto;
    TextView coloresProducto;
    TextView descripcionProducto;
    TextView fechaCompra;

    ImageView estrella1;
    ImageView estrella2;
    ImageView estrella3;
    ImageView estrella4;
    ImageView estrella5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages_miscompras);
        initComponents();
    }
    public void initComponents(){

        String temp = getIntent().getStringExtra("nombre");
        this.nombre = temp;
        estrella1 = findViewById(R.id.estrella1);
        estrella2 = findViewById(R.id.estrella2);
        estrella3 = findViewById(R.id.estrella3);
        estrella4 = findViewById(R.id.estrella4);
        estrella5 = findViewById(R.id.estrella5);

        nombreUsuario = findViewById(R.id.nombreUsuario);
        nombreProducto = findViewById(R.id.nombreProducto);
        estadoProducto = findViewById(R.id.estadoProducto);
        coloresProducto = findViewById(R.id.coloresProducto);
        descripcionProducto = findViewById(R.id.descripcionProducto);
        fechaCompra = findViewById(R.id.fechaCompra);

        presenter.verMisComprasPresenter(nombre);

    }

    @Override
    public void successVerMisComprasView(PagesMisComprasProducto producto) {
        System.out.println(producto.toString());
    }

    @Override
    public void failureVerMisComprasView(String err) {

    }
}
