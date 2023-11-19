package com.example.vinted.ValorarUsuario;

import com.example.vinted.Beans.Valoracion;

public interface ContractValorar {

    public interface View{

        void successValorarView(String respuesta);
        void failureValorarView(String err);


    }
    public interface Presenter{

        void valorarPresenter(String nombre, Valoracion valoracion);

    }
    public interface Model{
        interface UserListener{
            void onFinished(String respuesta);
            void onFailure(String err);
        }
        void valorarModel(ContractValorar.Model.UserListener presenter, String nombre ,Valoracion valoracion);

    }

}
