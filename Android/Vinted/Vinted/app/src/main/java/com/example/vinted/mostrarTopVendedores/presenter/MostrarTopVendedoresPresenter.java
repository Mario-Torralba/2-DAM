package com.example.vinted.mostrarTopVendedores.presenter;

import com.example.vinted.mostrarTopVendedores.ContractMostrarTopVendedores;
import com.example.vinted.mostrarTopVendedores.Data.Usuario;
import com.example.vinted.mostrarTopVendedores.model.MostrarTopVendedoresModel;

import java.util.ArrayList;

public class MostrarTopVendedoresPresenter implements ContractMostrarTopVendedores.Presenter , ContractMostrarTopVendedores.Model.UserListener {

    ContractMostrarTopVendedores.View view;
    ContractMostrarTopVendedores.Model model;

    public MostrarTopVendedoresPresenter(ContractMostrarTopVendedores.View view) {
        this.view = view;
        this.model = new MostrarTopVendedoresModel();
    }

    @Override
    public void verMisVentasPresenter() {
        model.verMisVentasModel(this);
    }

    @Override
    public void onFinished(ArrayList<Usuario> lstUsuarios) {
        view.successVerMisVentasView(lstUsuarios);
    }

    @Override
    public void onFailure(String err) {

    }
}
