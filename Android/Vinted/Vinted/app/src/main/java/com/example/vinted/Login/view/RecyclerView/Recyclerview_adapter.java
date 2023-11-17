package com.example.vinted.Login.view.RecyclerView;

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

public class Recyclerview_adapter extends RecyclerView.Adapter<Recyclerview_adapter.ViewHolder> {

    private ArrayList<com.example.vinted.Login.view.RecyclerView.recyclerview_list> recyclerview_list;
    private Context context;

    public Recyclerview_adapter(ArrayList<com.example.vinted.Login.view.RecyclerView.recyclerview_list> recyclerview_list, Context contexto) {
        this.recyclerview_list = recyclerview_list;
        this.context = contexto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_main_topvendedores,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imagen.setImageResource(recyclerview_list.get(position).getImage());
        holder.nombre_apellidos.setText(recyclerview_list.get(position).getNombre_apellidos());
        holder.email.setText(recyclerview_list.get(position).getEmail());
        holder.telefono.setText(recyclerview_list.get(position).getTelefono());
        holder.ventas.setText(recyclerview_list.get(position).getVentas());

    }

    @Override
    public int getItemCount() {
        return recyclerview_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imagen;

        TextView nombre_apellidos;
        TextView email;
        TextView telefono;
        TextView ventas;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);

            imagen = itemView.findViewById(R.id.imagen);
            nombre_apellidos = itemView.findViewById(R.id.nombre_apellidos);
            email = itemView.findViewById(R.id.email);
            telefono = itemView.findViewById(R.id.telefono);
            ventas = itemView.findViewById(R.id.ventas);
        }
    }
}
