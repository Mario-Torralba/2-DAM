package Model.Beans.ProductosRelacionados;

import java.util.ArrayList;

public class DataProductosRelacionados {

    String message;
    ArrayList<ProductoRelacionado> lstProductosRelacionados = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ProductoRelacionado> getLstProductosRelacionados() {
        return lstProductosRelacionados;
    }

    public void setLstProductosRelacionados(ArrayList<ProductoRelacionado> lstProductosRelacionados) {
        this.lstProductosRelacionados = lstProductosRelacionados;
    }

}
