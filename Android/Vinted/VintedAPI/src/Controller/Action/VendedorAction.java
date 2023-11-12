package Controller.Action;

import Model.Beans.Producto;
import Model.Beans.Usuario;
import Model.DAO.VendedorDAO;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class VendedorAction implements IAction{
    Gson gson;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "buscarProductos":
                 cadDestino = buscarProductos(request, response);
                break;
            case "crearProducto":
                 cadDestino = crearProducto(request, response);
                break;
            case "verTOP10Vendedores":
                cadDestino = verTOP10Vendedores(request, response);
                break;
        }
        return cadDestino;
    }


    public String verTOP10Vendedores(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        ArrayList<Usuario> lstUsuarios = vendedor.verTOP10Vendedores();
        String json = gson.toJson(lstUsuarios);
        return json;
    }


    public String buscarProductos(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        ArrayList<Producto> lstProducto = vendedor.mostrarMisProductos(request.getParameter("ID"));
        String json = gson.toJson(lstProducto);
        return json;
    }

    public String crearProducto(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        String salida = vendedor.crearProducto(request.getParameter("ID"),request.getParameter("ESTADO"),request.getParameter("NOMBRE"),request.getParameter("DESCRIPCION"),request.getParameter("MARCA"),request.getParameter("PRECIO"),request.getParameter("IMAGEN"));
        return salida;
    }
}
