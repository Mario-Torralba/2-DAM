package com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.View;

import com.example.vinted.Beans.User;
import com.example.vinted.MisCompras.Data.MisProductosData;
import com.example.vinted.MisCompras.MisComprasContract;
import com.example.vinted.MisCompras.View.RecyclerViewMisCompras.PagesMisCompras.Data.PagesMisComprasProducto;

public interface ContractPagesMisCompras {

    public interface View{

        void successVerMisComprasView(PagesMisComprasProducto producto);
        void failureVerMisComprasView(String err);


    }
    public interface Presenter{

        void verMisComprasPresenter(String nombreProducto);

    }
    public interface Model{
        interface UserListener{
            void onFinished(PagesMisComprasProducto producto);
            void onFailure(String err);
        }
        void verMisComprasModel(String nombreProducto, UserListener userListener);

    }

}
