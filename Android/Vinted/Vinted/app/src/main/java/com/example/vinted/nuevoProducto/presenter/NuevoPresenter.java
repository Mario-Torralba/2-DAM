package com.example.vinted.nuevoProducto.presenter;

import com.example.vinted.Beans.Producto;
import com.example.vinted.Beans.User;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;
import com.example.vinted.nuevoProducto.model.NuevoModel;


public class NuevoPresenter implements ContractNuevoProducto.Presenter, ContractNuevoProducto.Model.UserListener {

    private ContractNuevoProducto.View view;
    private ContractNuevoProducto.Model model;

    public NuevoPresenter(ContractNuevoProducto.View view){
        this.view = view;
        this.model = new NuevoModel(this);
    }


    @Override
    public void crearProductoPresenter(Producto producto) {
        model.crearProductoModel(producto,this);
    }

    @Override
    public void successCrearProductoPresenter(String mensaje) {
        view.successCrearProductoView(mensaje);
    }

    @Override
    public void asociarCategoriasPresenter(Producto producto) {
        model.asociarCategoriasModel(producto, this);
    }

    @Override
    public void successAsociarCategoriasPresenter(String mensaje) {
        view.successAsociarCategoriasView(mensaje);
    }

    @Override
    public void asociarColoresPresenter(Producto producto) {
        model.asociarColoresModel(producto, this);
    }

    @Override
    public void successAsociarColoresPresenter(String mensaje) {
        view.successAsociarColoresView(mensaje);
    }

    @Override
    public void onFinished(String resp) {

    }

    @Override
    public void onFailure(String err) {

    }
}
