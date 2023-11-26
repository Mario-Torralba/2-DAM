package com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.View;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vinted.R;

public class PagesMisCompras extends AppCompatActivity {

    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        this.contexto = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages_miscompras);

//        int paginaId = getIntent().getIntExtra("id",0);
//        TextView pageid = findViewById(R.id.pageid);
//        pageid.setText("PRODUCT : " + paginaId + 1);
    }

}
