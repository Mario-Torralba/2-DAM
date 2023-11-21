package com.example.vinted.Busqueda.view.RecyclerViewBusqueda;

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

import com.example.vinted.CaracteristicasProducto.View.CaracteristicasView;
import com.example.vinted.R;
import com.example.vinted.ValorarUsuario.View.ValorarView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Recyclerview_list> recyclerviewLists;
    private Context contexto;

    public RecyclerViewAdapter(ArrayList<Recyclerview_list> recyclerviewLists, Context contexto) {
        this.recyclerviewLists = recyclerviewLists;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_busqueda,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imagen.setImageResource(recyclerviewLists.get(position).getImage());
        holder.titulo.setText(recyclerviewLists.get(position).getNombreProducto());
        holder.precio.setText(recyclerviewLists.get(position).getPrecio());

        holder.cardView.setOnClickListener(e->{
            Intent intent = new Intent(contexto, CaracteristicasView.class);
            intent.putExtra("nombreProducto",recyclerviewLists.get(position).getNombreProducto());
            contexto.startActivity(intent);
        });
//                holder.cardView.setOnClickListener(e->{
//            Intent intent = new Intent(context, ValorarView.class);
//            intent.putExtra("nombre",recyclerview_list.get(position).getNombre_apellidos());
//            context.startActivity(intent);
//        });

    }

    @Override
    public int getItemCount() {
        return recyclerviewLists.size();
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
