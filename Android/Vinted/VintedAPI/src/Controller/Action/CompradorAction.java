package Controller.Action;

import Model.Beans.ArrayProductos;
import Model.Beans.ProductoCaracteristicas.ProductoCaracteristicas;
import Model.DAO.CompradorDAO;
import Model.DAO.VendedorDAO;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompradorAction implements IAction{

    Gson gson = new Gson();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "caracteristicasProducto":
                cadDestino = caracteristicasProducto(request, response);
                break;
        }
        return cadDestino;
    }

    public String caracteristicasProducto(HttpServletRequest request, HttpServletResponse response){
        CompradorDAO comprador = new CompradorDAO();
        ProductoCaracteristicas productoCaracteristicas = comprador.caracteristicasProducto(request.getParameter("NOMBRE"));
        String json = gson.toJson(productoCaracteristicas);
        System.out.println(json);
        return json;
    }
}
