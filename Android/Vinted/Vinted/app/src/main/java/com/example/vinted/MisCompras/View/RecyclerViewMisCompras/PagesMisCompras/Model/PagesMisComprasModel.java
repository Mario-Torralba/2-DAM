package com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.Model;

import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.Data.PagesMisComprasProducto;
import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.View.ContractPagesMisCompras;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagesMisComprasModel implements ContractPagesMisCompras.Model {

    @Override
    public void verMisComprasModel(String nombreProducto, UserListener userListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        Call<PagesMisComprasProducto> call = apiService.getMisCompras2("COMPRADOR.verMisCompras", nombreProducto);

        call.enqueue(new Callback<PagesMisComprasProducto>() {
            @Override
            public void onResponse(Call<PagesMisComprasProducto> call, Response<PagesMisComprasProducto> response) {
                PagesMisComprasProducto data = response.body();
                userListener.onFinished(data);
            }

            @Override
            public void onFailure(Call<PagesMisComprasProducto> call, Throwable t) {

            }
        });
    }

}
