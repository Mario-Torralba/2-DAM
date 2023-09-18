package api.model;

import api.dao.ProductDAO;

public class ProductAction {

    public void altaProducto(String nombreProducto,int precioProducto){

        ProductDAO producto = new ProductDAO();
        producto.altaProductoDAO();

    }
    public void bajaProducto(int idBaja){
        ProductDAO producto = new ProductDAO();
        producto.bajaProductoDAO();
    }

    public void listarProductos() {
        ProductDAO producto = new ProductDAO();
        producto.listarProductosDAO();
    }
    public void modificarProducto(int idModificacion,String nombreModificar,int precioModificar){
        ProductDAO producto = new ProductDAO();
        producto.modificarProductosDAO();
    }

}
