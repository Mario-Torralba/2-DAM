package com.example.vinted.MostrarTopValoraciones.Presenter;

import com.example.vinted.MostrarTopValoraciones.ContractMostrarTopValoraciones;
import com.example.vinted.MostrarTopValoraciones.Data.UsuarioValoraciones;
import com.example.vinted.MostrarTopValoraciones.Model.MostrarValoracionesModel;
import com.example.vinted.mostrarTopVendedores.Data.Usuario;

import java.util.ArrayList;

public class MostrarValoracionesPresenter implements ContractMostrarTopValoraciones.Presenter, ContractMostrarTopValoraciones.Model.UserListener {

    ContractMostrarTopValoraciones.View view;
    MostrarValoracionesModel model;

    public MostrarValoracionesPresenter(ContractMostrarTopValoraciones.View view) {
        this.view = view;
        this.model = new MostrarValoracionesModel();
    }

    @Override
    public void verTopValoracionesPresenter() {
        model.VerTopValoracionesModel(this);
    }

    @Override
    public void onFinished(ArrayList<UsuarioValoraciones> lstUsuarios) {
        view.successVerTopValoracionesView(lstUsuarios);
    }

    @Override
    public void onFailure(String err) {

    }
}
