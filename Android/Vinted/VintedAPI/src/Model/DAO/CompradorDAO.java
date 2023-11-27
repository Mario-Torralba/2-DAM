package Model.DAO;

import Model.Beans.IdProducto;
import Model.Beans.PagesCompras.PagesMisComprasProducto;
import Model.Beans.ProductoCaracteristicas.MensajeCompra;
import Model.Beans.ProductoCaracteristicas.ProductoCaracteristicas;
import Model.Beans.ProductosRelacionados.DataProductosRelacionados;
import Model.Beans.ProductosRelacionados.ProductoRelacionado;
import Model.MotorSQL.MotorSQL;

import javax.xml.transform.Result;
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
                    colores += " " + rs.getString("nombre_color");
                }
            }
            productoCaracteristicas.setColores_producto(colores);
            SQL = "SELECT\n" +
                    "    U.ID_USUARIO AS ID_USUARIO,\n" +
                    "    U.NICK AS NICK,\n" +
                    "    AVG(V.ESTRELLAS) AS MEDIA_ESTRELLAS,\n" +
                    "    COUNT(*) AS CANTIDAD_VALORACIONES\n" +
                    "FROM\n" +
                    "    USUARIO U\n" +
                    "        LEFT JOIN\n" +
                    "    VALORACION V ON U.ID_USUARIO = V.ID_USUARIO\n" +
                    "WHERE\n" +
                    "        U.ID_USUARIO = " + productoCaracteristicas.getId_usuario_vendedor() +"\n" +
                    "GROUP BY\n" +
                    "    U.ID_USUARIO, U.NICK;";
            rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                productoCaracteristicas.setEstrellas(Math.round(rs.getInt("media_estrellas")));
                productoCaracteristicas.setCantidad_estrellas(rs.getInt("cantidad_valoraciones"));
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return productoCaracteristicas;

    }

    public DataProductosRelacionados verProductosRelacionados(String id_usuario){
        int idNum = Integer.parseInt(id_usuario);
        DataProductosRelacionados data = new DataProductosRelacionados();

        SQL = "SELECT P.nombre_producto, P.precio_producto\n" +
                "FROM PRODUCTO P\n" +
                "         LEFT JOIN VENTA V ON P.ID_PRODUCTO = V.ID_PRODUCTO\n" +
                "WHERE P.ID_USUARIO = "+ idNum +" AND V.ID_PRODUCTO IS NULL;";
        data.setMessage("Cagadón apoteósico");
        try{
            motorsql.connect();
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                ProductoRelacionado producto = new ProductoRelacionado();
                producto.setNombreProducto(rs.getString(1));
                producto.setPrecio(rs.getInt(2));
                data.getLstProductosRelacionados().add(producto);
            }
            data.setMessage("TODO PERLAS");
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return data;

    }

    public MensajeCompra realizarCompra(String nombreProducto, String id_vendedor, String id_comprador){
        int idVendedorNum = Integer.parseInt(id_vendedor);
        int idCompradorNum = Integer.parseInt(id_comprador);
        int idProducto = 0;
        MensajeCompra mensaje = new MensajeCompra();


        mensaje.setMessage("Cagadón apoteósico");
        try{
            motorsql.connect();
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery("SELECT * FROM PRODUCTO WHERE nombre_producto = '" + nombreProducto + "'");
            while (rs.next()){
                idProducto = rs.getInt("id_producto");
            }
            SQL = "INSERT INTO VENTA (ID_USUARIO_VENDEDOR, ID_USUARIO_COMPRADOR, ID_PRODUCTO, FECHA_VENTA)\n" +
                    "VALUES (" + idVendedorNum + ", " + idCompradorNum + ", " + idProducto +", CURRENT_DATE);";
            int salida = motorsql.execute(SQL);
            mensaje.setMessage("Se ha realizado la compra con éxito");
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return mensaje;

    }

    public PagesMisComprasProducto verMisCompras(String nombreProducto){

        PagesMisComprasProducto data = new PagesMisComprasProducto();
        SQL = "";
        try{
            motorsql.connect();
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery("SELECT * FROM PRODUCTO WHERE nombre_producto = '" + nombreProducto + "'");
            while (rs.next()){

            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return data;

    }
}
