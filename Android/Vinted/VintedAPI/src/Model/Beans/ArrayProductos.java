package Model.Beans;

import java.util.ArrayList;

public class ArrayProductos {

    private String message;
    private ArrayList<Producto> lstProducto = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(ArrayList<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

}
