package com.example.vinted.MisCompras.Model;

import com.example.vinted.MisCompras.Data.MisProductosData;
import com.example.vinted.MisCompras.MisComprasContract;
import com.example.vinted.MisVentas.ContractMisVentas;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;
import com.example.vinted.mostrarTopVendedores.Data.DataUsuarios;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisComprasModel implements MisComprasContract.Model {
    @Override
    public void verMisComprasModel(int id_usuario, UserListener userListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        Call<MisProductosData> call = apiService.getMisCompras("USUARIO.verMisCompras",id_usuario);
        call.enqueue(new Callback<MisProductosData>() {
            @Override
            public void onResponse(Call<MisProductosData> call, Response<MisProductosData> response) {
                MisProductosData data = response.body();
                userListener.onFinished(data);
            }

            @Override
            public void onFailure(Call<MisProductosData> call, Throwable t) {

            }
        });
    }
}
