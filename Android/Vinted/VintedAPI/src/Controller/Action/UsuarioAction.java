package Controller.Action;

import Model.Beans.Mensaje;
import Model.DAO.UsuarioDAO;
import com.google.gson.Gson;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioAction implements IAction{

    Gson gson = new Gson();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "LOGIN":
                cadDestino = userLogin(request, response);
                break;
            case "valorarVendedor":
                cadDestino = valorarVendedor(request, response);
                break;
        }
        return cadDestino;
    }

    public String userLogin(HttpServletRequest request, HttpServletResponse response){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Mensaje mensaje = usuarioDAO.userLogin(request.getParameter("USER"), request.getParameter("PASS"));
        String salida = gson.toJson(mensaje);
        return salida;
    }

    public String valorarVendedor(HttpServletRequest request, HttpServletResponse response){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Mensaje mensaje = usuarioDAO.valorarVendedor(request.getParameter("NOMBRE"), request.getParameter("ESTRELLAS"), request.getParameter("COMENTARIO"));
        String salida = gson.toJson(mensaje);
        return salida;
    }
}
