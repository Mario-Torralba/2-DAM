package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class main extends AppCompatActivity {


    ArrayList<recyclerview_list> recyclerview_list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerview_list = new ArrayList<recyclerview_list>();
        recyclerview_list.add(new recyclerview_list(R.drawable.akkari, "Akkari 1"));
        recyclerview_list.add(new recyclerview_list(R.drawable.akkari, "Akkari 2"));
        recyclerview_list.add(new recyclerview_list(R.drawable.akkari, "Akkari 3"));
        recyclerview_list.add(new recyclerview_list(R.drawable.akkari, "Akkari 4"));
        recyclerview_list.add(new recyclerview_list(R.drawable.akkari, "Akkari 5"));
        recyclerview_list.add(new recyclerview_list(R.drawable.akkari, "Akkari 6"));
        recyclerview_list.add(new recyclerview_list(R.drawable.akkari, "Akkari 7"));
        recyclerview_list.add(new recyclerview_list(R.drawable.akkari, "Akkari 8"));

        recyclerview_adapter recyclerview_adapter = new recyclerview_adapter(recyclerview_list,this);
        recyclerView.setAdapter(recyclerview_adapter);
    }
}