package com.example.vinted.Busqueda.presenter;

import com.example.vinted.Busqueda.ContractBusqueda;
import com.example.vinted.Busqueda.data.Producto;
import com.example.vinted.Busqueda.model.BusquedaModel;

import java.util.ArrayList;

public class BusquedaPresenter implements ContractBusqueda.Presenter, ContractBusqueda.Model.UserListener {

    ContractBusqueda.View view;
    BusquedaModel model;

    public BusquedaPresenter(ContractBusqueda.View view) {
        this.view = view;
        this.model = new BusquedaModel();
    }

    @Override
    public void hacerBusquedaPresenter(String categoria, String color, String busqueda) {
        model.hacerBusquedaModel(categoria, color, busqueda,this);
    }

    @Override
    public void onFinished(ArrayList<Producto> lstProducto) {
        view.successBusqueda(lstProducto);
    }

    @Override
    public void onFailure(String err) {

    }
}
