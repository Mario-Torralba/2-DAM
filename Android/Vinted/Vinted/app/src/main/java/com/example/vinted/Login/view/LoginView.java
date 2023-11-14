package com.example.vinted.Login.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.Beans.User;
import com.example.vinted.Login.ContractLogin;
import com.example.vinted.Login.presenter.LoginPresenter;
import com.example.vinted.R;

public class LoginView extends AppCompatActivity implements ContractLogin.View {

    private EditText usuario;
    private EditText contrasena;
    private Button botonLogin;
    private Context contexto;

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.contexto = this;
        initComponents();
    }
    private void initComponents(){
        usuario = findViewById(R.id.user);
        contrasena = findViewById(R.id.pass);
        botonLogin = findViewById(R.id.botonLogin);
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setUsername(usuario.getText().toString());
                user.setPassword(contrasena.getText().toString());

                loginPresenter.login(user);
            }
        });
    }
    @Override
    public void successLogin(String resp) {
        CharSequence txt = resp;
        Toast.makeText(contexto,txt,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureLogin(String err) {
        CharSequence txt = err;
        Toast.makeText(contexto,txt,Toast.LENGTH_SHORT).show();
    }
}
