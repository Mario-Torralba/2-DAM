package com.example.vinted.Busqueda.model;

import com.example.vinted.Busqueda.ContractBusqueda;
import com.example.vinted.Busqueda.data.DataProducto;
import com.example.vinted.MostrarTopValoraciones.Data.DataUsuarioValoracion;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusquedaModel implements ContractBusqueda.Model {
    @Override
    public void hacerBusquedaModel(String categoria, String color, String busqueda, UserListener userListener) {

        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        Call<DataProducto> call = apiService.busqueda("USUARIO.busqueda", categoria, color, busqueda);
        call.enqueue(new Callback<DataProducto>() {
            @Override
            public void onResponse(Call<DataProducto> call, Response<DataProducto> response) {
                DataProducto data = response.body();
                userListener.onFinished(data.getLstProducto());
            }

            @Override
            public void onFailure(Call<DataProducto> call, Throwable t) {

            }
        });
    }
}
