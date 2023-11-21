package Model.DAO;

import Model.Beans.IdProducto;
import Model.Beans.ProductoCaracteristicas.ProductoCaracteristicas;
import Model.MotorSQL.MotorSQL;

import java.sql.ResultSet;

public class CompradorDAO {

    MotorSQL motorsql;
    String SQL;

    public CompradorDAO(){
        motorsql = new MotorSQL();
    }

    public ProductoCaracteristicas caracteristicasProducto(String nombre){

        ProductoCaracteristicas productoCaracteristicas = new ProductoCaracteristicas();
        String colores = "";

        SQL = "SELECT * FROM PRODUCTO P\n" +
                "INNER JOIN PRODUCTO_CATEGORIA PC ON PC.ID_PRODUCTO = P.ID_PRODUCTO\n" +
                "INNER JOIN USUARIO U ON U.ID_USUARIO = P.ID_USUARIO\n" +
                "INNER JOIN CATEGORIA C ON PC.ID_CATEGORIA = C.ID_CATEGORIA\n" +
                "INNER JOIN PRODUCTO_COLOR PC2 ON PC2.ID_PRODUCTO = P.ID_PRODUCTO\n" +
                "INNER JOIN COLOR C2 ON C2.ID_COLOR = PC2.ID_COLOR\n" +
                "INNER JOIN ESTADO E ON E.ID_ESTADO = P.ID_ESTADO\n" +
                "WHERE UPPER(P.NOMBRE_PRODUCTO) LIKE UPPER('" + nombre +"');";
        try{
            motorsql.connect();
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);

            int contador = 0;
            while (rs.next()){
                if(contador==0){
                productoCaracteristicas.setId_usuario_comprador(1);
                productoCaracteristicas.setId_usuario_vendedor(rs.getInt("id_usuario"));
                productoCaracteristicas.setNombre_apellidos(rs.getString("nombre_usuario") + " " + rs.getString("apellido_1_usuario") + " " +rs.getString("apellido_2_usuario"));
                productoCaracteristicas.setNombre_producto(rs.getString("nombre_producto"));
                productoCaracteristicas.setEstado_producto(rs.getString("nombre_estado"));
                productoCaracteristicas.setPrecio_producto(rs.getInt("precio_producto"));
                productoCaracteristicas.setDescripcion_producto(rs.getString("descripcion_producto"));
                }
                contador++;
                if(colores.contains(rs.getString("nombre_color"))){
                }else{
                    colores += rs.getString("nombre_color");
                }
            }
            productoCaracteristicas.setColores_producto(colores);
            
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        System.out.println(productoCaracteristicas.toString());
        return productoCaracteristicas;

    }
}
