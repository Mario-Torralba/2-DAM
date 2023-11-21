package com.example.vinted.CaracteristicasProducto.View;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.Busqueda.data.Producto;
import com.example.vinted.CaracteristicasProducto.ContractCaracteristicasProducto;
import com.example.vinted.CaracteristicasProducto.Data.ProductoCaracteristicas;
import com.example.vinted.CaracteristicasProducto.Presenter.CaracteristicasPresenter;
import com.example.vinted.MisVentas.Presenter.MisVentasPresenter;
import com.example.vinted.R;

public class CaracteristicasView extends AppCompatActivity implements ContractCaracteristicasProducto.View {

    Context contexto;
    CaracteristicasPresenter presenter = new CaracteristicasPresenter(this);

    TextView nombreProducto;

    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas);
        initComponents();
    }

    public void initComponents(){

        String nombre = getIntent().getStringExtra("nombreProducto");
        nombreProducto.setText(nombre);

        presenter.caracteristicasProductoPresenter(this.nombreProducto.getText().toString());




    }

    @Override
    public void successCompra(ProductoCaracteristicas producto) {
        System.out.println(producto.toString());
    }

    @Override
    public void failureBusqueda(String err) {

    }
}
