package com.example.vinted.Login;

import com.example.vinted.Beans.User;

public interface ContractLogin {

    public interface View{
        public void successLogin(String String);
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void login(User user);
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
        void loginAPI(User user,
                      OnLoginUserListener onLoginUserListener);
    }

}
