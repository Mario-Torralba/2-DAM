package com.example.vinted.MisCompras.Presenter;

import com.example.vinted.MisCompras.Data.MisProductosData;
import com.example.vinted.MisCompras.MisComprasContract;
import com.example.vinted.MisCompras.Model.MisComprasModel;

public class MisComprasPresenter implements MisComprasContract.Presenter, MisComprasContract.Model.UserListener {

    MisComprasContract.View view;
    MisComprasModel model;

    public MisComprasPresenter(MisComprasContract.View view) {
        this.view = view;
        model = new MisComprasModel();
    }

    @Override
    public void verMisComprasPresenter(int id_usuario) {
        model.verMisComprasModel(id_usuario, this);
    }

    @Override
    public void onFinished(MisProductosData productos) {
        view.successVerMisComprasView(productos);
    }

    @Override
    public void onFailure(String err) {

    }
}
