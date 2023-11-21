package com.example.vinted.CaracteristicasProducto.Model;

import com.example.vinted.Busqueda.data.DataProducto;
import com.example.vinted.CaracteristicasProducto.ContractCaracteristicasProducto;
import com.example.vinted.CaracteristicasProducto.Data.ProductoCaracteristicas;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CaracteristicasModel implements ContractCaracteristicasProducto.Model {

    @Override
    public void caracteristicasProductoModel(String nombre_producto, UserListener userListener) {


        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        Call<ProductoCaracteristicas> call = apiService.caracteristicasProducto("COMPRADOR.caracteristicasProducto", nombre_producto);
        call.enqueue(new Callback<ProductoCaracteristicas>() {
            @Override
            public void onResponse(Call<ProductoCaracteristicas> call, Response<ProductoCaracteristicas> response) {
                ProductoCaracteristicas data = response.body();
                userListener.onFinished(data);
            }

            @Override
            public void onFailure(Call<ProductoCaracteristicas> call, Throwable t) {

            }
        });
    }
}
