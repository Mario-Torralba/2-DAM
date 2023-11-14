package com.example.vinted.Busqueda.presenter;//package com.example.vinted.nuevoProducto.presenter;
//
//import com.example.vinted.Beans.User;
//import com.example.vinted.nuevoProducto.ContractLogin;
//import com.example.vinted.nuevoProducto.model.NuevoModel;
//
//public class NuevoPresenter implements ContractLogin.Presenter, ContractLogin.Model.OnLoginUserListener {
//
//    private ContractLogin.View view;
//    private ContractLogin.Model model;
//
//    public NuevoPresenter(ContractLogin.View view){
//        this.view = view;
//        this.model = new NuevoModel(this);
//    }
//
//    @Override
//    public void login(User user) {
//        model.loginAPI(user,this);
//    }
//
//    @Override
//    public void onFinished(String resp) {
//
//        view.successLogin(resp);
//    }
//
//    @Override
//    public void onFailure(String err) {
//
//    }
//}
