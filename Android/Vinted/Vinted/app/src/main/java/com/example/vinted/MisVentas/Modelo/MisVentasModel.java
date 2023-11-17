package com.example.vinted.MisVentas.Modelo;

import android.util.Log;

import com.example.vinted.MisVentas.ContractMisVentas;
import com.example.vinted.MisVentas.Data.Producto;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;
import com.example.vinted.nuevoProducto.data.NuevoProductoData;

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
    public void verMisVentasModel(int id_usuario) {
        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        //Call<Producto> call  = apiService.getProductos("VENDEDOR.buscarProductos",id_usuario);
        Call<ArrayList<Producto>> call = apiService.getProductos("VENDEDOR.buscarProductos",id_usuario);
        call.enqueue(new Callback<ArrayList<Producto>>() {
            @Override
            public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                ArrayList<Producto> lstProductos = response.body();
                System.out.println(lstProductos.toString());
                presenter.successVerMisVentasPresenter(lstProductos);
            }

            @Override
            public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
}
