package com.example.vinted.ValorarUsuario.Presenter;

import com.example.vinted.Beans.Valoracion;
import com.example.vinted.ValorarUsuario.ContractValorar;
import com.example.vinted.ValorarUsuario.Model.ValorarUsuarioModel;

public class ValorarUsuarioPresenter implements ContractValorar.Presenter, ContractValorar.Model.UserListener {

    ContractValorar.View view;
    ValorarUsuarioModel model;

    public ValorarUsuarioPresenter(ContractValorar.View view) {
        this.view = view;
        this.model = new ValorarUsuarioModel();
    }

    @Override
    public void valorarPresenter(String nombre, Valoracion valoracion) {
        model.valorarModel(this,nombre, valoracion);
    }

    @Override
    public void onFinished(String respuesta) {
        view.successValorarView(respuesta);
    }

    @Override
    public void onFailure(String err) {

    }
}
