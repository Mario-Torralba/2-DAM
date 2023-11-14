package com.example.vinted.Mensajes;

import com.example.vinted.Beans.User;

public interface ContractMensajes {

    public interface View{
        public void successMensaje(String String);
        void failureMensaje(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void crear(User producto);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnLoginUserListener{
            void onFinished(String resp);
            void onFailure(String err);
        }
        void crear(User user,
                      OnLoginUserListener onLoginUserListener);
    }

}
