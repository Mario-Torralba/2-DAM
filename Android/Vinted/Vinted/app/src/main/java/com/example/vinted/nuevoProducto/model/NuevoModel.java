package com.example.vinted.nuevoProducto.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.vinted.Beans.Producto;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;
import com.example.vinted.nuevoProducto.data.IdProductoNuevo;
import com.example.vinted.nuevoProducto.data.NuevoProductoData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NuevoModel implements ContractNuevoProducto.Model{

    private ContractNuevoProducto.Presenter presenter;
    private static int idProductoIntroducido;
    public NuevoModel(ContractNuevoProducto.Presenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void crearProductoModel(Producto producto, UserListener userListener) {

        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);

        Call<NuevoProductoData> call  = apiService.createProduct("VENDEDOR.crearProducto",producto.getIdUsuario(),producto.getIdEstado(), producto.getTitulo(), producto.getDescripcion(), producto.getMarca(), producto.getPrecio(), producto.getImg());
        call.enqueue(new Callback<NuevoProductoData>() {
            @Override
            public void onResponse(Call<NuevoProductoData> call, Response<NuevoProductoData> response) {
                NuevoProductoData data = response.body();
                presenter.successCrearProductoPresenter(data.getMessage());
            }

            @Override
            public void onFailure(Call<NuevoProductoData> call, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }

    @Override
    public void asociarCategoriasModel(Producto producto, UserListener userListener) {

        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);
        Call <IdProductoNuevo> callid = apiService.recuperarId("VENDEDOR.recuperarId",producto.getTitulo());
        callid.enqueue(new Callback<IdProductoNuevo>() {
            @Override
            public void onResponse(Call<IdProductoNuevo> callid, Response<IdProductoNuevo> response) {
                IdProductoNuevo id = response.body();
                idProductoIntroducido = id.getId();
                for (int i = 0; i < producto.getLstCategorias().size(); i++) {
                    System.out.println(producto.getLstCategorias().get(i));
                    Call<NuevoProductoData> call2  = apiService.asociarCategorias("VENDEDOR.asociarCategorias",idProductoIntroducido,producto.getLstCategorias().get(i));
                    call2.enqueue(new Callback<NuevoProductoData>() {
                        @Override
                        public void onResponse(Call<NuevoProductoData> call2, Response<NuevoProductoData> response) {
                            NuevoProductoData data = response.body();
                            System.out.println(data.getMessage());

                        }

                        @Override
                        public void onFailure(Call<NuevoProductoData> call2, Throwable t) {
                            Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
                        }
                    });
                }
                presenter.successAsociarCategoriasPresenter("ASOCIADOS LAS CATEGORIAS");
            }

            @Override
            public void onFailure(Call<IdProductoNuevo> callid, Throwable t) {
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });


    }

    @Override
    public void asociarColoresModel(Producto producto, UserListener userListener) {

        for (int i = 0; i < producto.getLstColores().size(); i++) {

            System.out.println(idProductoIntroducido);
            System.out.println(producto.getLstColores().get(i));

            ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                    create(ApiService.class);
            Call <NuevoProductoData> call3 = apiService.asociarColores("VENDEDOR.asociarColores",idProductoIntroducido,producto.getLstColores().get(i));
            call3.enqueue(new Callback<NuevoProductoData>() {
                @Override
                public void onResponse(Call<NuevoProductoData> call3, Response<NuevoProductoData> response) {
                    NuevoProductoData data = response.body();
                    System.out.println(data.getMessage());
                }

                @Override
                public void onFailure(Call<NuevoProductoData> call3, Throwable t) {
                    Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
                }
            });
        }
        presenter.successAsociarColoresPresenter("ASOCIADOS COLORES");

    }
}
