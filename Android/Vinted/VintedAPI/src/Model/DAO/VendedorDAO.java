package Model.DAO;

import Model.MotorSQL.MotorSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class VendedorDAO {

    MotorSQL motorsql;
    String SQL;

    public VendedorDAO(){
        motorsql = new MotorSQL();
    }

    public String crearProducto(int id, String nombre, String descripcion, String marca, int precio, String imagen, String estado){
        String salida = "";
        SQL = "INSERT INTO PRODUCTO (ID_USUARIO, NOMBRE_PRODUCTO, DESCRIPCION_PRODUCTO, MARCA_PRODUCTO, PRECIO_PRODUCTO, IMAGEN_PRODUCTO, ESTADO) VALUES (?,?,?,?,?,?,?)";
        try{
            motorsql.connect();
            PreparedStatement sentencia = motorsql.conn.prepareStatement(SQL);
            sentencia.setInt(1,id);
            sentencia.setString(2,nombre);
            sentencia.setString(3,descripcion);
            sentencia.setString(4,marca);
            sentencia.setInt(5,precio);
            sentencia.setString(6,imagen);
            sentencia.setString(7,estado);
            System.out.println(sentencia);
            salida = motorsql.execute(sentencia);
            salida = "El producto se ha creado con exito";
        }catch(Exception ex) {
            salida = "Algo ha salido mal";
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return salida;
    }
}
