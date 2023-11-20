package com.example.vinted.MostrarTopValoraciones;

import com.example.vinted.MostrarTopValoraciones.Data.UsuarioValoraciones;
import com.example.vinted.mostrarTopVendedores.ContractMostrarTopVendedores;
import com.example.vinted.mostrarTopVendedores.Data.Usuario;

import java.util.ArrayList;

public interface ContractMostrarTopValoraciones {

    public interface View{

        void successVerTopValoracionesView(ArrayList<UsuarioValoraciones> lstUsuarios);
        void failureVerTopValoracionesView(String err);


    }
    public interface Presenter{

        void verTopValoracionesPresenter();

    }
    public interface Model{
        interface UserListener{
            void onFinished(ArrayList<UsuarioValoraciones> lstUsuarios);
            void onFailure(String err);
        }
        void VerTopValoracionesModel(ContractMostrarTopValoraciones.Model.UserListener presenter);

    }

}
