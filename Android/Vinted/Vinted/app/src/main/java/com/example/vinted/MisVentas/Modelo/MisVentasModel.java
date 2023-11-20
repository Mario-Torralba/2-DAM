package com.example.vinted.MisVentas.Modelo;

import android.util.Log;

import com.example.vinted.Login.data.MyData;
import com.example.vinted.MisVentas.ContractMisVentas;
import com.example.vinted.MisVentas.Data.ArrayProductos;
import com.example.vinted.MisVentas.Data.Producto;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;
import com.example.vinted.nuevoProducto.data.NuevoProductoData;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisVentasModel implements ContractMisVentas.Model {

    private ContractMisVentas.Presenter presenter;

    public MisVentasModel(ContractMisVentas.Presenter presenter){

        this.presenter = presenter;
    }


    @Override
    public void verMisVentasModel(int id_usuario, UserListener presenter) {

        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        Call<ArrayProductos> call = apiService.getProductos("VENDEDOR.buscarProductos", id_usuario);
        call.enqueue(new Callback<ArrayProductos>() {
            @Override
            public void onResponse(Call<ArrayProductos> call, Response<ArrayProductos> response) {
                if (response.isSuccessful()) {
                    ArrayProductos productos = response.body();
                    presenter.onFinished(productos.getLstProducto());
                } else {
                    Log.e("Response Error", "Código de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("Response Error", "Cuerpo de error: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayProductos> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });

    }
}
