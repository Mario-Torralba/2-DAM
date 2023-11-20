package com.example.vinted.MostrarTopValoraciones.Model;

import com.example.vinted.MostrarTopValoraciones.ContractMostrarTopValoraciones;
import com.example.vinted.MostrarTopValoraciones.Data.DataUsuarioValoracion;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;
import com.example.vinted.mostrarTopVendedores.Data.DataUsuarios;
import com.example.vinted.mostrarTopVendedores.Data.Usuario;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostrarValoracionesModel implements ContractMostrarTopValoraciones.Model{


    @Override
    public void VerTopValoracionesModel(UserListener presenter) {

        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        Call<DataUsuarioValoracion> call = apiService.getTopValoraciones("USUARIO.verValoraciones");

        call.enqueue(new Callback<DataUsuarioValoracion>() {
            @Override
            public void onResponse(Call<DataUsuarioValoracion> call, Response<DataUsuarioValoracion> response) {
                DataUsuarioValoracion data = response.body();
                presenter.onFinished(data.getLstUsuarios());
            }

            @Override
            public void onFailure(Call<DataUsuarioValoracion> call, Throwable t) {

            }
        });
    }
}
