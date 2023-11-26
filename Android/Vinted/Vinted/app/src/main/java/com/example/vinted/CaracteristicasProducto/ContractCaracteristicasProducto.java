package com.example.vinted.CaracteristicasProducto;

import com.example.vinted.Busqueda.ContractBusqueda;
import com.example.vinted.Busqueda.data.Producto;
import com.example.vinted.CaracteristicasProducto.Data.DataProductoRelacionado;
import com.example.vinted.CaracteristicasProducto.Data.ProductoCaracteristicas;

import java.util.ArrayList;

public interface ContractCaracteristicasProducto {

    public interface View {
        void successCaracteristicas(ProductoCaracteristicas producto);
        void successProductosRelacionados(DataProductoRelacionado data);
        void successCompra(String resp);
        void failureBusqueda(String err);

    }

    public interface Presenter {

        void caracteristicasProductoPresenter(String nombre_producto);
        void productosRelacionadosPresenter(int id_usuario);
        void compraPresenter(String nombreProducto, int id_usuario_vendedor, int id_usuario_comprador);

    }

    public interface Model {

        interface UserListener {
            void onFinished(ProductoCaracteristicas producto);
            void onFinished2(DataProductoRelacionado data);
            void onFinishedCompra(String resp);
            void onFailure(String err);
        }

        void caracteristicasProductoModel(String nombre_producto, ContractCaracteristicasProducto.Model.UserListener userListener);
        void productosRelacionadosModel(int id_usuario, ContractCaracteristicasProducto.Model.UserListener userListener);
        void compraModel(String nombreProducto, int id_usuario_vendedor, int id_usuario_comprador , ContractCaracteristicasProducto.Model.UserListener userListener);
    }

}
