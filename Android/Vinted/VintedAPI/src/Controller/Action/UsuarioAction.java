package Controller.Action;

import Model.DAO.UsuarioDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioAction implements IAction{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "LOGIN":
                cadDestino = userLogin(request, response);
                break;
        }
        return cadDestino;
    }

    public String userLogin(HttpServletRequest request, HttpServletResponse response){

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        String salida = usuarioDAO.userLogin(request.getParameter("USER"), request.getParameter("PASS"));

        return salida;
    }
}
