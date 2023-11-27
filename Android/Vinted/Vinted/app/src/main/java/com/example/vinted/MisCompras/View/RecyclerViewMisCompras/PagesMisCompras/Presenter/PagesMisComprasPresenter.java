package com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.Presenter;

import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.Data.PagesMisComprasProducto;
import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.Model.PagesMisComprasModel;
import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.View.ContractPagesMisCompras;

public class PagesMisComprasPresenter implements ContractPagesMisCompras.Presenter, ContractPagesMisCompras.Model.UserListener {

    ContractPagesMisCompras.View view;
    PagesMisComprasModel model;

    public PagesMisComprasPresenter(ContractPagesMisCompras.View view) {
        model = new PagesMisComprasModel();
        this.view = view;
    }

    @Override
    public void verMisComprasPresenter(String nombreProducto) {
        model.verMisComprasModel(nombreProducto, this);
    }

    @Override
    public void onFinished(PagesMisComprasProducto producto) {
        view.successVerMisComprasView(producto);
    }

    @Override
    public void onFailure(String err) {

    }
}
