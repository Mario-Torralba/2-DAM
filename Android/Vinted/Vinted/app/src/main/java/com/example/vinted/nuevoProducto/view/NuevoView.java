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


public class NuevoView extends AppCompatActivity implements ContractNuevoProducto.View {

    public static Producto producto = new Producto();
    Context contexto;

    EditText titulo;
    EditText descripcion;
    EditText precio;
    EditText marca;
    LinearLayout crearProducto;

    LinearLayout categoria;

    LinearLayout estado;
    TextView estadoTexto;
    ImageView estadoImagen;

    String categoriaString;
    String marcaString;
    String estadoString;

//    private NuevoPresenter nuevoPresenter = new NuevoPresenter(this);

    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        initComponents();
    }

    private void initComponents(){

        this.titulo = findViewById(R.id.titulo);
        this.descripcion = findViewById(R.id.descripcion);
        this.marca = findViewById(R.id.marca);
        this.precio = (EditText)findViewById(R.id.precio);
        this.crearProducto = findViewById(R.id.crearProducto);
        this.categoria = findViewById(R.id.categoria);
        this.estado = findViewById(R.id.estado);
        this.estadoTexto = findViewById(R.id.estadoTexto);
        this.estadoImagen = findViewById(R.id.estadoImagen);

        if(producto.getTitulo()!=null || producto.getDescripcion()!=null || producto.getMarca()!=null){
            titulo.setText(producto.getTitulo());
            descripcion.setText(producto.getDescripcion());
            marca.setText(producto.getMarca());
        }

        if(EstadoView.estadoFinal!=null){
            estado.setBackgroundColor(getResources().getColor(R.color.vinted));
            estadoTexto.setText("Estado - " + EstadoView.estadoFinal);
            estadoTexto.setTextColor(getResources().getColor(R.color.white));
            estadoImagen.setImageResource(R.drawable.lineaverde);
        }


        crearProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(producto.getEstado()!=null || producto.getCategoria()!= null || producto.getTitulo()!= null || producto.getDescripcion() !=null || producto.getMarca()!=null || producto.getPrecio()!=0){
                    Toast.makeText(contexto,"Faltan campos por rellenar",Toast.LENGTH_SHORT).show();
                }else{
                    if(producto.getEstado()=="Nuevo con etiquetas"){
                        producto.setIdEstado(1);
                    }
                    if(producto.getEstado()=="Nuevo sin etiquetas"){
                        producto.setIdEstado(2);
                    }
                    if(producto.getEstado()=="Bueno"){
                        producto.setIdEstado(3);
                    }
                    if(producto.getEstado()=="Muy bueno"){
                        producto.setIdEstado(4);
                    }
                    if(producto.getEstado()=="Satisfactorio"){
                        producto.setIdEstado(5);
                    }
                    producto.setMarca(marca.getText().toString());
                    producto.setTitulo(titulo.getText().toString());
                    producto.setDescripcion(descripcion.getText().toString());
                    String text = precio.getText().toString();
                    int precioInt = new Integer(text).intValue();
                    producto.setPrecio(precioInt);
                    producto.setImg("Nada por aqui");
                    System.out.println(producto.toString());
                }

            }
        });


            estado.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(EstadoView.estadoFinal!=null){
                    }else{
                        if(producto.getMarca()!=null){
                            producto.setMarca(marca.getText().toString());
                        }
                        if(producto.getTitulo()!=null){
                            producto.setTitulo(titulo.getText().toString());
                        }
                        if(producto.getDescripcion()!=null){
                            producto.setDescripcion(descripcion.getText().toString());
                        }
                        Intent intent = new Intent(NuevoView.this, EstadoView.class);
                        finish();
                        startActivity(intent);
                    }

                }
            });





    }
    @Override
    public void successCrear(String resp) {
    }

    @Override
    public void failureCrear(String err) {

    }
}
