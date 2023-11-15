package com.example.vinted.Login.model;

import android.util.Log;
import android.widget.Toast;

import com.example.vinted.Beans.User;
import com.example.vinted.Login.ContractLogin;
import com.example.vinted.Login.data.MyData;
import com.example.vinted.Util.ApiService;
import com.example.vinted.Util.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements ContractLogin.Model{

    private ContractLogin.Presenter presenter;

    public LoginModel(ContractLogin.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void loginAPI(User user, OnLoginUserListener onLoginUserListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + RetrofitCliente.IP_BASE + "/").
                create(ApiService.class);

        Call<MyData> call = apiService.getDataUser ("USUARIO.LOGIN",user.getUsername(), user.getPassword());
        call.enqueue(new Callback<MyData>() {

            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                if (response.isSuccessful()) {

                    MyData myData = response.body();
                    System.out.println(myData.getMessage());
                    String message = myData.getMessage();
                    onLoginUserListener.onFinished(message);
                    // Actualizar la interfaz de usuario con el mensaje recibido
                } else {
                    // Manejar una respuesta no exitosa
                    Log.e("Response Error", "Código de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("Response Error", "Cuerpo de error: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MyData> call, Throwable t) {
                // Manejar errores de red o del servidor
                Log.e("Response Error", "Cuerpo de error: " + t.getMessage());
            }
        });
    }
}
