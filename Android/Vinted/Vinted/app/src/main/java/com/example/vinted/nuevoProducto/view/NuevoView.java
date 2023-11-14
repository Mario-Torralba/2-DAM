package com.example.vinted.nuevoProducto.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.vinted.R;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;


public class NuevoView extends AppCompatActivity implements ContractNuevoProducto.View {

    Context contexto;
//    private NuevoPresenter nuevoPresenter = new NuevoPresenter(this);

    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        initComponents();
    }
    private void initComponents(){

    }
    @Override
    public void successCrear(String resp) {
    }

    @Override
    public void failureCrear(String err) {

    }
}
