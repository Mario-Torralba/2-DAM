package com.example.vinted.CaracteristicasProducto.Presenter;

import com.example.vinted.Busqueda.data.Producto;
import com.example.vinted.CaracteristicasProducto.ContractCaracteristicasProducto;
import com.example.vinted.CaracteristicasProducto.Data.DataProductoRelacionado;
import com.example.vinted.CaracteristicasProducto.Data.ProductoCaracteristicas;
import com.example.vinted.CaracteristicasProducto.Model.CaracteristicasModel;

public class CaracteristicasPresenter implements ContractCaracteristicasProducto.Presenter, ContractCaracteristicasProducto.Model.UserListener
{
    ContractCaracteristicasProducto.View view;
    CaracteristicasModel model;

    public CaracteristicasPresenter(ContractCaracteristicasProducto.View view) {
        this.view = view;
        this.model = new CaracteristicasModel();
    }


    @Override
    public void caracteristicasProductoPresenter(String nombre_producto) {
        model.caracteristicasProductoModel(nombre_producto, this);
    }

    @Override
    public void productosRelacionadosPresenter(int id_usuario) {
        model.productosRelacionadosModel(id_usuario, this);
    }


    @Override
    public void onFinished(ProductoCaracteristicas producto) {
        view.successCaracteristicas(producto);
    }

    @Override
    public void onFinished2(DataProductoRelacionado data) {
        view.successProductosRelacionados(data);
    }

    @Override
    public void onFailure(String err) {

    }

}
