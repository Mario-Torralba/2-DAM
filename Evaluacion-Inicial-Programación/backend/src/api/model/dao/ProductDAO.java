package api.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import api.model.MotorSQL;
import api.model.beans.Producto;

public class ProductDAO {

    MotorSQL motorsql;
    String sql;

    public static final String SQL_INSERT = "INSERT INTO PRODUCTO (idProveedor,nombreProducto,precioProducto) VALUES (";
    public static final String SQL_DELETE = "DELETE FROM PRODUCTO WHERE idProducto = ";
    public static final String SQL_FIND = "SELECT * FROM PRODUCTO WHERE 1=1 ";
    public static final String SQL_UPDATE = "UPDATE PRODUCTO SET ";

    public ProductDAO(){
        motorsql= new MotorSQL();
        motorsql.connect();
    }

    public void altaProductoDAO(String idProveedor,String nombreProducto, int precioProducto){
        Producto producto = new Producto();
        try{

        sql = SQL_INSERT;
        sql +=  idProveedor + ",'" + nombreProducto + "', " + precioProducto + ")";

        int resp = motorsql.execute(sql);
        sql = SQL_FIND;
        sql += "AND";
        sql += " idProveedor LIKE " + idProveedor +" ";
        sql += "AND";
        sql += " nombreProducto LIKE '%" + nombreProducto +"%' ";
        sql += "AND";
        sql += " precioProducto LIKE " + precioProducto +" ";

        ResultSet rs = motorsql.executeQuery(sql);

        while(rs.next()){
            producto.setIdProducto(rs.getInt("idProducto"));
            producto.setIdProveedor(rs.getInt("idProveedor"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setPrecioProducto(rs.getInt("precioProducto"));
        }

            System.out.println(producto.toString());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            motorsql.disconnect();
        }
    }
    public void bajaProductoDAO(int idBaja){

        try{
            sql = SQL_DELETE;
            sql += idBaja;
            int resp = motorsql.execute(sql);
            System.out.println("\n PRODUCTO ELIMINADO CON ÉXITO");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            motorsql.disconnect();
        }


    }
    public void listarProductosDAO(){
        ArrayList<Producto>listaProductos= new ArrayList<>();
        try{
            sql = SQL_FIND;
            ResultSet rs = motorsql.executeQuery(sql);

            while(rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setIdProveedor(rs.getInt("idProveedor"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setPrecioProducto(rs.getInt("precioProducto"));
                listaProductos.add(producto);
            }
            for (Producto e:
                 listaProductos) {
                System.out.println(e.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            motorsql.disconnect();
        }

        
    }
    public void modificarProductosDAO(int idModificacion,String nombreModificar,int precioModificar){
        try{
            sql = SQL_UPDATE;
            sql += "nombreProducto = '" + nombreModificar + "'";
            sql += " WHERE idProducto = " + idModificacion + " ";
            int respuesta = motorsql.execute(sql);
            sql = SQL_UPDATE;
            sql += "precioProducto = " + precioModificar;
            sql += " WHERE idProducto = " + idModificacion + " ";
            respuesta = motorsql.execute(sql);
            System.out.println("\n PRODUCTO MODIFICADO CON ÉXITO");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            motorsql.disconnect();
        }
    }
}
