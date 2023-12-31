package Controller.Action;

import Model.Beans.ArrayProductos;
import Model.Beans.PagesCompras.PagesMisComprasProducto;
import Model.Beans.ProductoCaracteristicas.MensajeCompra;
import Model.Beans.ProductoCaracteristicas.ProductoCaracteristicas;
import Model.Beans.ProductosRelacionados.DataProductosRelacionados;
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
            case "verProductosRelacionados":
                cadDestino = verProductosRelacionados(request, response);
                break;
            case "realizarCompra":
                cadDestino = realizarCompra(request, response);
                break;
            case "verMisCompras":
                cadDestino = verMisCompras(request, response);
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

    public String verProductosRelacionados(HttpServletRequest request, HttpServletResponse response){
        CompradorDAO comprador = new CompradorDAO();
        DataProductosRelacionados data = comprador.verProductosRelacionados(request.getParameter("ID_USUARIO"));
        String json = gson.toJson(data);
        System.out.println(json);
        return json;
    }

    public String realizarCompra(HttpServletRequest request, HttpServletResponse response){
        CompradorDAO comprador = new CompradorDAO();
        MensajeCompra mensaje = comprador.realizarCompra(request.getParameter("NOMBRE_PRODUCTO"), request.getParameter("ID_VENDEDOR"), request.getParameter("ID_COMPRADOR") );
        String json = gson.toJson(mensaje);
        System.out.println(json);
        return json;
    }

    public String verMisCompras(HttpServletRequest request, HttpServletResponse response){
        CompradorDAO comprador = new CompradorDAO();
        PagesMisComprasProducto data = comprador.verMisCompras(request.getParameter("NOMBRE_PRODUCTO"));
        String json = gson.toJson(data);
        System.out.println(json);
        return json;
    }
}
