package api.model.dao;

import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import api.model.MotorSQL;
import api.model.beans.Producto;

public class ProductDAO {

    MotorSQL motorsql;
    String sql;

    public static final String SQL_INSERT = "INSERT INTO PRODUCTO (nombreProducto,precioProducto) VALUES (";
    public static final String SQL_DELETE = "D";
    public static final String SQL_FIND = "SELECT * FROM PRODUCT WHERE 1=1 ";

    public ProductDAO(){
        motorsql= new MotorSQL();
        motorsql.connect();
    }

    public void altaProductoDAO(String nombreProducto, int precioProducto){

        try{

        sql = SQL_INSERT;
        sql += "'" + nombreProducto + "', " + precioProducto + ")";

        int resp = motorsql.execute(sql);

        System.out.println("Producto con id");
        System.out.println("Producto con nombre " + nombreProducto);
        System.out.println("Producto con precio " + precioProducto);

        }catch(Exception e){
            System.out.println(e);
        }finally{
            motorsql.disconnect();
        }


    }
    public void bajaProductoDAO(int idBaja){

        sql = SQL_FIND;
        ResultSet rs = motorsql.executeQuery(sql);

    }
    public void listarProductosDAO(){

        sql = SQL_FIND;
        ResultSet rs = motorsql.executeQuery(sql);
        Producto producto;
        
    }
    public void modificarProductosDAO(int idModificacion,String nombreModificar,int precioModificar){
        
    }
}
