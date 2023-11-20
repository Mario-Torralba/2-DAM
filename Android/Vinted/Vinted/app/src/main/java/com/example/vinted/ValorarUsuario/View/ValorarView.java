package com.example.vinted.ValorarUsuario.View;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.Beans.Valoracion;
import com.example.vinted.Login.ContractLogin;
import com.example.vinted.R;
import com.example.vinted.ValorarUsuario.ContractValorar;
import com.example.vinted.ValorarUsuario.Presenter.ValorarUsuarioPresenter;

public class ValorarView extends AppCompatActivity implements ContractValorar.View {

    ValorarUsuarioPresenter presenter = new ValorarUsuarioPresenter(this);

    int estrellas;
    TextView comentario;
    LinearLayout enviarValoracion;

    Context contexto;
    String nombre;


    ImageView estrella1;
    ImageView estrella2;
    ImageView estrella3;
    ImageView estrella4;
    ImageView estrella5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages_valorar);
        this.contexto = this;
        initComponents();
    }

    public void initComponents(){

        String atributos = getIntent().getStringExtra("nombre");
        TextView nombreVendedor = findViewById(R.id.nombreVendedor);
        nombreVendedor.setText("Dejar una valoración para " + atributos);

        this.nombre = atributos;

        this.estrella1 = findViewById(R.id.estrella1);
        this.estrella2 = findViewById(R.id.estrella2);
        this.estrella3 = findViewById(R.id.estrella3);
        this.estrella4 = findViewById(R.id.estrella4);
        this.estrella5 = findViewById(R.id.estrella5);
        this.comentario = findViewById(R.id.comentario);
        this.enviarValoracion = findViewById(R.id.enviarValoracion);

        estrella1.setOnClickListener(e->{
            reinicioEstrellas();
            estrella1.setImageResource(R.drawable.estrella_llena);
            this.estrellas = 1;
        });
        estrella2.setOnClickListener(e->{
            reinicioEstrellas();
            estrella1.setImageResource(R.drawable.estrella_llena);
            estrella2.setImageResource(R.drawable.estrella_llena);
            this.estrellas = 2;
        });
        estrella3.setOnClickListener(e->{
            reinicioEstrellas();
            estrella1.setImageResource(R.drawable.estrella_llena);
            estrella2.setImageResource(R.drawable.estrella_llena);
            estrella3.setImageResource(R.drawable.estrella_llena);
            this.estrellas = 3;
        });
        estrella4.setOnClickListener(e->{
            reinicioEstrellas();
            estrella1.setImageResource(R.drawable.estrella_llena);
            estrella2.setImageResource(R.drawable.estrella_llena);
            estrella3.setImageResource(R.drawable.estrella_llena);
            estrella4.setImageResource(R.drawable.estrella_llena);
            this.estrellas = 4;
        });
        estrella5.setOnClickListener(e->{
            reinicioEstrellas();
            estrella1.setImageResource(R.drawable.estrella_llena);
            estrella2.setImageResource(R.drawable.estrella_llena);
            estrella3.setImageResource(R.drawable.estrella_llena);
            estrella4.setImageResource(R.drawable.estrella_llena);
            estrella5.setImageResource(R.drawable.estrella_llena);
            this.estrellas = 5;
        });

        enviarValoracion.setOnClickListener(e->{
            Valoracion valoracion = new Valoracion();
            valoracion.setEstrellas(estrellas);
            valoracion.setComentario(comentario.getText().toString());
            presenter.valorarPresenter(nombre, valoracion);

        });


    }
    public void reinicioEstrellas(){
        estrella1.setImageResource(R.drawable.estrella_vacia);
        estrella2.setImageResource(R.drawable.estrella_vacia);
        estrella3.setImageResource(R.drawable.estrella_vacia);
        estrella4.setImageResource(R.drawable.estrella_vacia);
        estrella5.setImageResource(R.drawable.estrella_vacia);
    }
    @Override
    public void successValorarView(String respuesta) {

        System.out.println(respuesta);
        Toast.makeText(contexto,"LA VALORACION HA SIDO ENVIADA", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void failureValorarView(String err) {

    }
}
