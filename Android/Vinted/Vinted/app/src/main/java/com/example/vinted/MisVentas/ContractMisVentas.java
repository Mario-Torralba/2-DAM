package com.example.vinted.MisVentas;

import com.example.vinted.Beans.Producto;
import com.example.vinted.nuevoProducto.ContractNuevoProducto;

import java.util.ArrayList;

public interface ContractMisVentas {


        public interface View{

            void successVerMisVentasView(ArrayList<com.example.vinted.MisVentas.Data.Producto> lstProductos);
            void failureVerMisVentasView(String err);


        }
        public interface Presenter{

            void verMisVentasPresenter(int id_usuario);
            void successVerMisVentasPresenter(ArrayList<com.example.vinted.MisVentas.Data.Producto> lstProductos);


        }
        public interface Model{
            interface UserListener{
                void onFinished(String resp);
                void onFailure(String err);
            }
            void verMisVentasModel(int id_usuario);

        }

}


