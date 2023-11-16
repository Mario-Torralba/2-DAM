package com.example.vinted.nuevoProducto;

import com.example.vinted.Beans.Producto;
import com.example.vinted.Beans.User;

public interface ContractNuevoProducto {

    public interface View{

        void successCrearProductoView(String String);
        void failureCrearProductoView(String err);

        void successAsociarCategoriasView(String String);
        void failureAsociarCategoriasView(String err);

        void successAsociarColoresView(String String);
        void failureAsociarColoresView(String err);

    }
    public interface Presenter{

        void crearProductoPresenter(Producto producto);
        void successCrearProductoPresenter(String string);
        void asociarCategoriasPresenter(Producto producto);
        void successAsociarCategoriasPresenter(String string);
        void asociarColoresPresenter(Producto producto);
        void successAsociarColoresPresenter(String string);

    }
    public interface Model{
        interface UserListener{
            void onFinished(String resp);
            void onFailure(String err);
        }
        void crearProductoModel(Producto producto, UserListener userListener);
        void asociarCategoriasModel(Producto producto, UserListener userListener);
        void asociarColoresModel(Producto producto, UserListener userListener);
    }

}
