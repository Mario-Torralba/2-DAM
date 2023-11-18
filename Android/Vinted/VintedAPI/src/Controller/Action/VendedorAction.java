package Controller.Action;

import Model.Beans.*;
import Model.Beans.TopVendedores.DataUsuarios;
import Model.DAO.VendedorDAO;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class VendedorAction implements IAction{
    Gson gson = new Gson();
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
            case "recuperarId":
                cadDestino = recuperarId(request, response);
                break;
            case "asociarCategorias":
                cadDestino = asociarCategorias(request, response);
                break;
            case "asociarColores":
                cadDestino = asociarColores(request, response);
                break;
        }
        return cadDestino;
    }


    public String verTOP10Vendedores(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        DataUsuarios dataUsuarios = vendedor.verTOP10Vendedores();
        String json = gson.toJson(dataUsuarios);
        System.out.println(json);
        return json;
    }


    public String buscarProductos(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        ArrayProductos arrayProductos = vendedor.mostrarMisProductos(request.getParameter("ID_USUARIO"));
        String json = gson.toJson(arrayProductos);
        System.out.println(json);
        return json;
    }

    public String crearProducto(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        Mensaje mensaje = vendedor.crearProducto(request.getParameter("ID"),request.getParameter("ESTADO"),request.getParameter("NOMBRE"),request.getParameter("DESCRIPCION"),request.getParameter("MARCA"),request.getParameter("PRECIO"),request.getParameter("IMAGEN"));
        String salida = gson.toJson(mensaje);
        return salida;
    }

    public String recuperarId(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        IdProducto salida = vendedor.recuperarId(request.getParameter("NOMBRE"));
        String json = gson.toJson(salida);
        return json;
    }

    public String asociarCategorias(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        Mensaje mensaje = vendedor.asociarCategorias(request.getParameter("ID_PRODUCTO"), request.getParameter("ID_CATEGORIA"));
        String json = gson.toJson(mensaje);
        System.out.println(json);
        return json;
    }

    public String asociarColores(HttpServletRequest request, HttpServletResponse response){
        VendedorDAO vendedor = new VendedorDAO();
        Mensaje mensaje = vendedor.asociarColores(request.getParameter("ID_PRODUCTO"), request.getParameter("ID_COLORES"));
        String json = gson.toJson(mensaje);
        System.out.println(json);
        return json;
    }
}
