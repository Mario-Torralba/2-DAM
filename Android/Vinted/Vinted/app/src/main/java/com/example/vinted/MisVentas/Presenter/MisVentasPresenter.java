package com.example.vinted.MisVentas.Presenter;

import com.example.vinted.Beans.Producto;
import com.example.vinted.MisVentas.ContractMisVentas;
import com.example.vinted.MisVentas.Modelo.MisVentasModel;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;
import com.example.vinted.nuevoProducto.model.NuevoModel;

import java.util.ArrayList;

public class MisVentasPresenter implements ContractMisVentas.Presenter {

    private ContractMisVentas.View view;
    private ContractMisVentas.Model model;

    public MisVentasPresenter(ContractMisVentas.View view){
        this.view = view;
        this.model = new MisVentasModel(this);
    }

    @Override
    public void verMisVentasPresenter(int id_usuario) {
        model.verMisVentasModel(id_usuario);
    }

    @Override
    public void successVerMisVentasPresenter(ArrayList<com.example.vinted.MisVentas.Data.Producto> lstProductos) {
        view.successVerMisVentasView(lstProductos);
    }
}
