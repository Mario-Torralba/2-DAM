package com.example.vinted.nuevoProducto.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.Beans.Producto;
import com.example.vinted.Busqueda.view.BusquedaView;
import com.example.vinted.MainActivity;
import com.example.vinted.Mensajes.view.MensajesView;
import com.example.vinted.Perfil.view.PerfilView;
import com.example.vinted.R;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;
import com.example.vinted.nuevoProducto.presenter.NuevoPresenter;


public class NuevoView extends AppCompatActivity implements ContractNuevoProducto.View {

    public static Producto producto = new Producto();
    Context contexto;

    EditText titulo;
    EditText descripcion;
    EditText precio;
    EditText marca;
    LinearLayout crearProducto;

    LinearLayout categoria;
    TextView categoriaTexto;

    LinearLayout estado;
    TextView estadoTexto;
    ImageView estadoImagen;

    LinearLayout color;
    TextView colorTexto;
    ImageView colorImagen;

    LinearLayout home;
    LinearLayout buscar;
    LinearLayout crear;
    LinearLayout mensajes;
    LinearLayout perfil;


    NuevoPresenter nuevoPresenter = new NuevoPresenter(this);

    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        initComponents();
    }

    private void initComponents(){

        this.home = findViewById(R.id.home);
        this.buscar = findViewById(R.id.buscar);
        this.crear = findViewById(R.id.crear);
        this.mensajes = findViewById(R.id.mensajes);
        this.perfil = findViewById(R.id.perfil);

        this.titulo = findViewById(R.id.titulo);
        this.descripcion = findViewById(R.id.descripcion);
        this.marca = findViewById(R.id.marca);
        this.precio = (EditText)findViewById(R.id.precio);
        this.crearProducto = findViewById(R.id.crearProducto);
        this.categoria = findViewById(R.id.categoria);
        this.categoriaTexto = findViewById(R.id.categoriaTexto);
        this.estado = findViewById(R.id.estado);
        this.estadoTexto = findViewById(R.id.estadoTexto);
        this.estadoImagen = findViewById(R.id.estadoImagen);
        this.color = findViewById(R.id.color);
        this.colorTexto = findViewById(R.id.colorTexto);
        this.colorImagen = findViewById(R.id.colorImagen);


        if(producto.getTitulo()!=null || producto.getDescripcion()!=null || producto.getMarca()!=null){
            titulo.setText(producto.getTitulo());
            descripcion.setText(producto.getDescripcion());
            marca.setText(producto.getMarca());
        }

        if(EstadoView.estadoFinal!=null){
            estado.setBackgroundColor(getResources().getColor(R.color.vinted));
            estadoTexto.setText("Estado - " + EstadoView.estadoFinal);
            estadoTexto.setTextColor(getResources().getColor(R.color.white));
        }

        if(producto.getEstado()!=null){
            if(producto.getEstado().equals("Nuevo con etiquetas")){
                producto.setIdEstado(1);
            }
            if(producto.getEstado().equals("Nuevo sin etiquetas")){
                producto.setIdEstado(2);
            }
            if(producto.getEstado().equals("Bueno")){
                producto.setIdEstado(3);
            }
            if(producto.getEstado().equals("Muy bueno")){
                producto.setIdEstado(4);
            }
            if(producto.getEstado().equals("Satisfactorio")){
                producto.setIdEstado(5);
            }
        }


        if(producto.getLstCategoriasString().size()!=0){
            categoria.setBackgroundColor(getResources().getColor(R.color.vinted));
            categoriaTexto.setTextColor(getResources().getColor(R.color.white));
            String categoriaFinal = "Categoría/as - ";
            int contador = 1;
            for (String e :producto.getLstCategoriasString()) {
                if(contador==producto.getLstCategoriasString().size()){
                    categoriaFinal += e;
                }else{
                    categoriaFinal += e + ", ";
                }
                contador++;
            }
            categoriaTexto.setText(categoriaFinal);

        }

        if(producto.getLstColoresString().size()!=0){
            color.setBackgroundColor(getResources().getColor(R.color.vinted));
            colorTexto.setTextColor(getResources().getColor(R.color.white));
            String colorFinal = "Categoría/as - ";
            int contador = 1;
            for (String e :producto.getLstColoresString()) {
                if(contador==producto.getLstColoresString().size()){
                    colorFinal += e;
                }else{
                    colorFinal += e + ", ";
                }
                contador++;
            }
            colorTexto.setText(colorFinal);

        }



        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                producto.setMarca(marca.getText().toString());
                producto.setTitulo(titulo.getText().toString());
                producto.setDescripcion(descripcion.getText().toString());

                Intent intent = new Intent(NuevoView.this, EstadoView.class);
                finish();
                startActivity(intent);


            }
        });

        categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                producto.setMarca(marca.getText().toString());
                producto.setTitulo(titulo.getText().toString());
                producto.setDescripcion(descripcion.getText().toString());

                Intent intent = new Intent(NuevoView.this, CategoriaView.class);
                finish();
                startActivity(intent);
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                producto.setMarca(marca.getText().toString());
                producto.setTitulo(titulo.getText().toString());
                producto.setDescripcion(descripcion.getText().toString());

                Intent intent = new Intent(NuevoView.this, ColorView.class);
                finish();
                startActivity(intent);
            }
        });


        crearProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                producto.setMarca(marca.getText().toString());
                producto.setTitulo(titulo.getText().toString());
                producto.setDescripcion(descripcion.getText().toString());
                String text = precio.getText().toString();
                int precioInt = new Integer(text).intValue();
                producto.setPrecio(precioInt);
                producto.setImg("Nada por aqui");

                if(producto.getIdEstado()==0 || producto.getLstCategorias()== null || producto.getTitulo()== null || producto.getDescripcion() ==null || producto.getMarca()==null || producto.getPrecio()==0 || producto.getLstColores()==null){
                    Toast.makeText(contexto,"Faltan campos por rellenar",Toast.LENGTH_SHORT).show();
                    System.out.println(producto.toString());
                }else{
                    System.out.println(producto.toString());
                    nuevoPresenter.crearProductoPresenter(producto);
//                    nuevoPresenter.asociarColoresPresenter(producto);
                }

            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevoView.this, BusquedaView.class);
                startActivity(intent);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevoView.this, PerfilView.class);
                startActivity(intent);
            }
        });

        mensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevoView.this, MensajesView.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NuevoView.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void successCrearProductoView(String mensaje) {
        nuevoPresenter.asociarCategoriasPresenter(producto);
    }

    @Override
    public void failureCrearProductoView(String err) {

    }

    @Override
    public void successAsociarCategoriasView(String mensaje) {
        nuevoPresenter.asociarColoresPresenter(producto);
    }

    @Override
    public void failureAsociarCategoriasView(String err) {

    }

    @Override
    public void successAsociarColoresView(String mensaje) {
        Intent intent = new Intent(NuevoView.this, MainActivity.class);
        startActivity(intent);
        finish();
        Toast.makeText(contexto,"Producto creado con exito", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureAsociarColoresView(String err) {

    }
}
