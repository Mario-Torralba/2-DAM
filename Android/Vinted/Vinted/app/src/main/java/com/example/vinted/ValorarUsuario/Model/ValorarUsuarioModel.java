package com.example.vinted.ValorarUsuario.Model;

import android.util.Log;

import com.example.vinted.Beans.Valoracion;
import com.example.vinted.MisVentas.Data.ArrayProductos;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;
import com.example.vinted.ValorarUsuario.ContractValorar;
import com.example.vinted.ValorarUsuario.Data.ValorarMensaje;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ValorarUsuarioModel implements ContractValorar.Model {



    @Override
    public void valorarModel(UserListener presenter, String nombre, Valoracion valoracion) {
        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        //Call<Producto> call  = apiService.getProductos("VENDEDOR.buscarProductos",id_usuario);
        Call<ValorarMensaje> call = apiService.valorarVendedor("USUARIO.valorarVendedor",nombre,valoracion.getEstrellas(), valoracion.getComentario());
        call.enqueue(new Callback<ValorarMensaje>() {
            @Override
            public void onResponse(Call<ValorarMensaje> call, Response<ValorarMensaje> response) {
                ValorarMensaje mensaje = response.body();
                presenter.onFinished(mensaje.getMessage());
            }

            @Override
            public void onFailure(Call<ValorarMensaje> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
}
