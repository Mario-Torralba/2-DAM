package com.example.vinted.CaracteristicasProducto;

import com.example.vinted.Busqueda.ContractBusqueda;
import com.example.vinted.Busqueda.data.Producto;
import com.example.vinted.CaracteristicasProducto.Data.ProductoCaracteristicas;

import java.util.ArrayList;

public interface ContractCaracteristicasProducto {

    public interface View {
        void successCompra(ProductoCaracteristicas producto);

        void failureBusqueda(String err);

    }

    public interface Presenter {

        void caracteristicasProductoPresenter(String nombre_producto);

    }

    public interface Model {

        interface UserListener {
            void onFinished(ProductoCaracteristicas producto);

            void onFailure(String err);
        }

        void caracteristicasProductoModel(String nombre_producto, ContractCaracteristicasProducto.Model.UserListener userListener);
    }

}
