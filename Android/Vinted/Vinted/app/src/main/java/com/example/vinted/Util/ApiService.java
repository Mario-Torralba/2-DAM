package com.example.vinted.Util;


import com.example.vinted.Busqueda.data.DataProducto;
import com.example.vinted.CaracteristicasProducto.Data.DataProductoRelacionado;
import com.example.vinted.CaracteristicasProducto.Data.MensajeCompra;
import com.example.vinted.CaracteristicasProducto.Data.ProductoCaracteristicas;
import com.example.vinted.Login.data.MyData;
import com.example.vinted.MisCompras.Data.MisProductosData;
import com.example.vinted.MisVentas.Data.ArrayProductos;
import com.example.vinted.MisVentas.Data.Producto;
import com.example.vinted.MostrarTopValoraciones.Data.DataUsuarioValoracion;
import com.example.vinted.ValorarUsuario.Data.ValorarMensaje;
import com.example.vinted.mostrarTopVendedores.Data.DataUsuarios;
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


    @GET("Controller")
    Call<DataUsuarios> getTopVendedores(@Query("ACTION") String action);

    @GET("Controller")
    Call<DataUsuarioValoracion> getTopValoraciones(@Query("ACTION") String action);

    @GET("Controller")
    Call<ValorarMensaje> valorarVendedor(@Query("ACTION") String action, @Query("NOMBRE") String nombre, @Query("ESTRELLAS") int estrellas, @Query("COMENTARIO") String comentario);

    @GET("Controller")
    Call<DataProducto> busqueda(@Query("ACTION") String action, @Query("CATEGORIA") String categoria, @Query("COLOR") String color, @Query("BUSQUEDA") String busqueda);

    @GET("Controller")
    Call<ProductoCaracteristicas> caracteristicasProducto(@Query("ACTION") String action, @Query("NOMBRE") String nombre_usuario);

    @GET("Controller")
    Call<DataProductoRelacionado> getProductosRelacionados(@Query("ACTION") String action, @Query("ID_USUARIO") int id_usuario);

    @GET("Controller")
    Call<MisProductosData> getMisCompras(@Query("ACTION") String action, @Query("ID_USUARIO") int id_usuario);

    @GET("Controller")
    Call<MensajeCompra> comprarProducto(@Query("ACTION") String action, @Query("NOMBRE_PRODUCTO") String nombreProducto, @Query("ID_VENDEDOR") int id_vendedor, @Query("ID_COMPRADOR") int id_comprador);
    //@GET("MyServlet")
    //Call<DataMovies> getDataMovies(@Query("ACTION") String action);

}
