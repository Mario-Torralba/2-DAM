package com.example.vinted.Login.presenter;

import com.example.vinted.Beans.User;
import com.example.vinted.Login.ContractLogin;
import com.example.vinted.Login.model.LoginModel;

public class LoginPresenter implements ContractLogin.Presenter, ContractLogin.Model.OnLoginUserListener {

    private ContractLogin.View view;
    private ContractLogin.Model model;

    public LoginPresenter(ContractLogin.View view){
        this.view = view;
        this.model = new LoginModel(this);
    }

    @Override
    public void login(User user) {
        model.loginAPI(user,this);
    }

    @Override
    public void onFinished(String resp) {
        view.successLogin(resp);
    }

    @Override
    public void onFailure(String err) {

    }
}
