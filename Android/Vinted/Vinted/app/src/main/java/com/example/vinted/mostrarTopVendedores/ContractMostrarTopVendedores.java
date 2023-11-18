package com.example.vinted.mostrarTopVendedores;



import com.example.vinted.mostrarTopVendedores.Data.Usuario;

import java.util.ArrayList;

public interface ContractMostrarTopVendedores {

    public interface View{

        void successVerMisVentasView(ArrayList<Usuario> lstUsuarios);
        void failureVerMisVentasView(String err);


    }
    public interface Presenter{

        void verMisVentasPresenter();

    }
    public interface Model{
        interface UserListener{
            void onFinished(ArrayList<Usuario> lstUsuarios);
            void onFailure(String err);
        }
        void verMisVentasModel(ContractMostrarTopVendedores.Model.UserListener presenter);

    }

}
