package com.example.vinted.Util;


import com.example.vinted.Login.data.MyData;
import com.example.vinted.MisVentas.Data.ArrayProductos;
import com.example.vinted.MisVentas.Data.Producto;
import com.example.vinted.nuevoProducto.data.IdProductoNuevo;
import com.example.vinted.nuevoProducto.data.NuevoProductoData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @GET("Controller")
    Call<MyData> getDataUser(@Query("ACTION") String action, @Query("USER") String nick, @Query("PASS") String pass);


    @GET("Controller")
    Call<NuevoProductoData> createProduct(@Query("ACTION") String action, @Query("ID") int id_usuario, @Query("ESTADO") int id_estado, @Query("NOMBRE") String titulo, @Query("DESCRIPCION") String descripcion, @Query("MARCA") String marca, @Query("PRECIO")  int precio, @Query("IMAGEN") String imagen);


    @GET("Controller")
    Call<IdProductoNuevo> recuperarId(@Query("ACTION") String action, @Query("NOMBRE") String nombreProducto);


    @GET("Controller")
    Call<NuevoProductoData> asociarCategorias(@Query("ACTION") String action, @Query("ID_PRODUCTO") int id_producto, @Query("ID_CATEGORIA") int id_categoria);

    @GET("Controller")
    Call<NuevoProductoData> asociarColores(@Query("ACTION") String action, @Query("ID_PRODUCTO") int id_producto, @Query("ID_COLORES") int id_colores);


    @GET("Controller")
    Call<ArrayProductos> getProductos(@Query("ACTION") String action, @Query("ID_USUARIO") int id_usuario);
    //@GET("MyServlet")
    //Call<DataMovies> getDataMovies(@Query("ACTION") String action);

}
