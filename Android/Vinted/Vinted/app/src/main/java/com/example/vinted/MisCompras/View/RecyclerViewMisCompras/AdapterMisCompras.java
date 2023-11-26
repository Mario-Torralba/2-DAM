package com.example.vinted.MisCompras.View.RecyclerViewMisCompras;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.View.PagesMisCompras;
import com.example.vinted.MisVentas.View.pages;
import com.example.vinted.MisVentas.View.recyclerview_adapter;
import com.example.vinted.MisVentas.View.recyclerview_list;
import com.example.vinted.R;

import java.util.ArrayList;

public class AdapterMisCompras extends RecyclerView.Adapter<AdapterMisCompras.ViewHolder2>{

    private ArrayList<RecyclerView_list_mis_compras> recyclerview_list;
    private Context context;

    public AdapterMisCompras(ArrayList<RecyclerView_list_mis_compras> recyclerview_list, Context contexto) {
        this.recyclerview_list = recyclerview_list;
        this.context = contexto;
    }

    @NonNull
    @Override
    public AdapterMisCompras.ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_producto_misventas,parent,false);
        return new AdapterMisCompras.ViewHolder2(view);
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterMisCompras.ViewHolder2 holder, int position) {

        holder.imageView.setImageResource(recyclerview_list.get(position).getImage());
        holder.textView.setText(recyclerview_list.get(position).getTitulo());
        holder.cardView.setOnClickListener(e->{
            Intent intent = new Intent(context, PagesMisCompras.class);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return recyclerview_list.size();
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
