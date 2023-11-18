package com.example.vinted.mostrarTopVendedores.model;

import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;
import com.example.vinted.mostrarTopVendedores.ContractMostrarTopVendedores;
import com.example.vinted.mostrarTopVendedores.Data.DataUsuarios;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostrarTopVendedoresModel implements ContractMostrarTopVendedores.Model {



    @Override
    public void verMisVentasModel(UserListener presenter) {
        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        Call<DataUsuarios> call = apiService.getTopVendedores("VENDEDOR.verTOP10Vendedores");
        call.enqueue(new Callback<DataUsuarios>() {
            @Override
            public void onResponse(Call<DataUsuarios> call, Response<DataUsuarios> response) {
                DataUsuarios data = response.body();
                presenter.onFinished(data.getLstUsuarios());
            }

            @Override
            public void onFailure(Call<DataUsuarios> call, Throwable t) {

            }
        });
    }

}
