package api.controller.action;

import api.model.dao.ProductDAO;

public class ProductAction { 

    public void altaProducto(String idProveedor,String nombreProducto,int precioProducto){

        ProductDAO producto = new ProductDAO();
        producto.altaProductoDAO(idProveedor,nombreProducto, precioProducto);

    }
    public void bajaProducto(int idBaja){
        ProductDAO producto = new ProductDAO();
        producto.bajaProductoDAO(idBaja);
    }

    public void listarProductos() {
        ProductDAO producto = new ProductDAO();
        producto.listarProductosDAO();
    }
    public void modificarProducto(int idModificacion,String nombreModificar,int precioModificar){
        ProductDAO producto = new ProductDAO();
        producto.modificarProductosDAO(idModificacion,nombreModificar,precioModificar);
    }

}
