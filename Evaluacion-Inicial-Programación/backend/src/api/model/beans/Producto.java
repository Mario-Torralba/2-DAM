package api.model.beans;

import java.util.ArrayList;

public class Producto {
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", idProveedor=" + idProveedor +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                '}';
    }

    private int idProducto;
    private int idProveedor;
    private String nombreProducto;
    private int precioProducto;


    public int getIdProveedor() {
        return idProveedor;
    }
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public static String toArrayJson(ArrayList<Producto>listaProductos){
        String resp = "";
        return resp;
    }

    public static String toXML(ArrayList<Producto>listaProductos){
        String resp = "";
        return resp;
    }

    

}
