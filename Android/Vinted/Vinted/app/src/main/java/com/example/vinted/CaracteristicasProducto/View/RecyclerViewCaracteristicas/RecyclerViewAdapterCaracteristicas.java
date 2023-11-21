package com.example.vinted.CaracteristicasProducto.View.RecyclerViewCaracteristicas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vinted.R;

import java.util.ArrayList;

public class RecyclerViewAdapterCaracteristicas extends RecyclerView.Adapter<RecyclerViewAdapterCaracteristicas.ViewHolder> {

    private ArrayList<RecyclerViewListCaracteristicas> recyclerViewListCaracteristicas;
    private Context contexto;

    public RecyclerViewAdapterCaracteristicas(ArrayList<RecyclerViewListCaracteristicas> recyclerViewListCaracteristicas, Context contexto) {
        this.recyclerViewListCaracteristicas = recyclerViewListCaracteristicas;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterCaracteristicas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_busqueda,parent,false);
        return new RecyclerViewAdapterCaracteristicas.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterCaracteristicas.ViewHolder holder, int position) {

        holder.imagen.setImageResource(recyclerViewListCaracteristicas.get(position).getImage());
        holder.titulo.setText(recyclerViewListCaracteristicas.get(position).getNombreProducto());
        holder.precio.setText(recyclerViewListCaracteristicas.get(position).getPrecio());

    }

    @Override
    public int getItemCount() {
        return recyclerViewListCaracteristicas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imagen;
        TextView titulo;
        TextView precio;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardViewBusqueda);
            imagen = itemView.findViewById(R.id.imagenBusqueda);
            titulo = itemView.findViewById(R.id.tituloBusqueda);
            precio = itemView.findViewById(R.id.precioBusqueda);



        }
    }
}
