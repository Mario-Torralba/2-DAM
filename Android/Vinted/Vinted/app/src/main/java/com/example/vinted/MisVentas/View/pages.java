package com.example.vinted.MisVentas.View;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.R;

public class pages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages);

        int paginaId = getIntent().getIntExtra("id",0);
        TextView pageid = findViewById(R.id.pageid);
        pageid.setText("PRODUCT : " + paginaId + 1);
    }
}
