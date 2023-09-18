package api.model;

import api.dao.ProductDAO;

public class ProductAction {

    public void altaProducto(String nombreProducto,int precioProducto){

        ProductDAO producto = new ProductDAO();
        producto.altaProducto();

    }
    public void bajaProducto(int idBaja){
        ProductDAO producto = new ProductDAO();
        producto.bajaProducto();
    }

    public void listarProductos() {
        ProductDAO producto = new ProductDAO();
        producto.listarProductos();
    }
    public void modificarProducto(int idModificacion,String nombreModificar,int precioModificar){
        ProductDAO producto = new ProductDAO();
        producto.modificarProductos();
    }

}
