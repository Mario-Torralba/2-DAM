package com.example.vinted.CompraProducto;

import com.example.vinted.Busqueda.ContractBusqueda;
import com.example.vinted.Busqueda.data.Producto;

import java.util.ArrayList;

public interface ContractCompraProducto {

    public interface View {
        void successCompra(ArrayList<Producto> lstProducto);

        void failureBusqueda(String err);

    }

    public interface Presenter {

        void hacerBusquedaPresenter(String categoria, String color, String busqueda);

    }

    public interface Model {

        interface UserListener {
            void onFinished(ArrayList<Producto> lstProducto);

            void onFailure(String err);
        }

        void hacerBusquedaModel(String categoria, String color, String busqueda, ContractBusqueda.Model.UserListener userListener);
    }
}
