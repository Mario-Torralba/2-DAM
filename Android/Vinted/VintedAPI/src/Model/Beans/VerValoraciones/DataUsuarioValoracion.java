package Model.Beans.VerValoraciones;

import java.util.ArrayList;

public class DataUsuarioValoracion {


    String message;
    ArrayList<UsuarioValoraciones> lstUsuarios = new ArrayList();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<UsuarioValoraciones> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(ArrayList<UsuarioValoraciones> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

}
