package com.example.vinted.Busqueda;

import com.example.vinted.Beans.User;
import com.example.vinted.Busqueda.data.Producto;

import java.util.ArrayList;

public interface ContractBusqueda {

    public interface View{
        void successBusqueda(ArrayList<Producto> lstProducto);
        void failureBusqueda(String err);

    }
    public interface Presenter{

        void hacerBusquedaPresenter(String categoria, String color, String busqueda);

    }
    public interface Model{

        interface UserListener{
            void onFinished(ArrayList<Producto> lstProducto);
            void onFailure(String err);
        }
        void hacerBusquedaModel(String categoria, String color, String busqueda, UserListener userListener);
    }

}
