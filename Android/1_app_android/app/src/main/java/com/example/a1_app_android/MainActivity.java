package com.example.a1_app_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtUser;
    private EditText edtPass;
    private Button btnSignIn;

    /* CICLO DE VIDA: ONLOAD JAVASCRIPT */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* document.getElementById("isUser"); */
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnSignIn  = findViewById(R.id.btnSignIn);

        // btnSignIn.addEventListener("click",function);

        btnSignIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }
}