package Model.Beans.MisCompras;

import java.util.ArrayList;

public class MisProductosData {
    String message;
    ArrayList<Producto> lstProductos = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(ArrayList<Producto> lstProductos) {
        this.lstProductos = lstProductos;
    }

}
