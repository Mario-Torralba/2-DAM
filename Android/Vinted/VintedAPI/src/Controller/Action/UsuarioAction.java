package Controller.Action;

import Model.Beans.Busqueda.DataProducto;
import Model.Beans.Mensaje;
import Model.Beans.MisCompras.MisProductosData;
import Model.Beans.VerValoraciones.DataUsuarioValoracion;
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

            case "verValoraciones":
                cadDestino = verValoraciones(request, response);
                break;

            case "busqueda":
                cadDestino = busqueda(request, response);
                break;
            case "verMisCompras":
                cadDestino = verMisCompras(request, response);
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

    public String verValoraciones(HttpServletRequest request, HttpServletResponse response){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DataUsuarioValoracion dataUsuarioValoracion = usuarioDAO.verValoraciones();
        String salida = gson.toJson(dataUsuarioValoracion);
        System.out.println(salida);
        return salida;
    }

    public String busqueda(HttpServletRequest request, HttpServletResponse response){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DataProducto dataProducto = usuarioDAO.busqueda(request.getParameter("CATEGORIA"), request.getParameter("COLOR"), request.getParameter("BUSQUEDA"));
        String salida = gson.toJson(dataProducto);
        System.out.println(salida);
        return salida;
    }

    public String verMisCompras(HttpServletRequest request, HttpServletResponse response){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        MisProductosData data = usuarioDAO.verMisCompras(request.getParameter("ID_USUARIO"));
        String salida = gson.toJson(data);
        System.out.println(salida);
        return salida;
    }

}
