package com.example.vinted.MisCompras;

import com.example.vinted.MisCompras.Data.MisProductosData;


public interface MisComprasContract {

    public interface View{

        void successVerMisComprasView(MisProductosData productos);
        void failureVerMisComprasView(String err);


    }
    public interface Presenter{

        void verMisComprasPresenter(int id_usuario);

    }
    public interface Model{
        interface UserListener{
            void onFinished(MisProductosData productos);
            void onFailure(String err);
        }
        void verMisComprasModel(int id_usuario, UserListener userListener);

    }

}
