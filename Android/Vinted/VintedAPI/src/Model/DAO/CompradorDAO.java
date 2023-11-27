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
        SQL = "SELECT\n" +
                "    V.ID_VENTA,\n" +
                "    U1.NICK AS COMPRADOR_NICK,\n" +
                "    U1.NOMBRE_USUARIO AS COMPRADOR_NOMBRE,\n" +
                "    U1.APELLIDO_1_USUARIO AS COMPRADOR_APELLIDO1,\n" +
                "    U1.APELLIDO_2_USUARIO AS COMPRADOR_APELLIDO2,\n" +
                "    P.NOMBRE_PRODUCTO AS PRODUCTO_NOMBRE,\n" +
                "    P.DESCRIPCION_PRODUCTO AS PRODUCTO_DESCRIPCION,\n" +
                "    P.MARCA_PRODUCTO AS PRODUCTO_MARCA,\n" +
                "    P.PRECIO_PRODUCTO AS PRODUCTO_PRECIO,\n" +
                "    U2.NICK AS VENDEDOR_NICK,\n" +
                "    U2.NOMBRE_USUARIO AS VENDEDOR_NOMBRE,\n" +
                "    U2.APELLIDO_1_USUARIO AS VENDEDOR_APELLIDO1,\n" +
                "    U2.APELLIDO_2_USUARIO AS VENDEDOR_APELLIDO2,\n" +
                "    AVG(VA.ESTRELLAS) AS VALORACION_MEDIA_VENDEDOR,\n" +
                "    COUNT(DISTINCT VA.ID_VALORACION) AS CANTIDAD_VALORACIONES_VENDEDOR,\n" +
                "    E.NOMBRE_ESTADO AS ESTADO_DEL_PRODUCTO,\n" +
                "    V.FECHA_VENTA AS FECHA_DE_VENTA\n" +
                "FROM VENTA V\n" +
                "INNER JOIN USUARIO U1 ON V.ID_USUARIO_COMPRADOR = U1.ID_USUARIO\n" +
                "INNER JOIN PRODUCTO P ON V.ID_PRODUCTO = P.ID_PRODUCTO\n" +
                "INNER JOIN USUARIO U2 ON P.ID_USUARIO = U2.ID_USUARIO\n" +
                "LEFT JOIN VALORACION VA ON P.ID_USUARIO = VA.ID_USUARIO\n" +
                "LEFT JOIN PRODUCTO_COLOR PC ON P.ID_PRODUCTO = PC.ID_PRODUCTO\n" +
                "LEFT JOIN ESTADO E ON P.ID_ESTADO = E.ID_ESTADO\n" +
                "WHERE P.NOMBRE_PRODUCTO = '"+nombreProducto+"'\n" +
                "GROUP BY V.ID_VENTA, U1.NICK, U1.NOMBRE_USUARIO, U1.APELLIDO_1_USUARIO, U1.APELLIDO_2_USUARIO,\n" +
                "         P.NOMBRE_PRODUCTO, P.DESCRIPCION_PRODUCTO, P.MARCA_PRODUCTO, P.PRECIO_PRODUCTO,\n" +
                "         U2.NICK, U2.NOMBRE_USUARIO, U2.APELLIDO_1_USUARIO, U2.APELLIDO_2_USUARIO,\n" +
                "         E.NOMBRE_ESTADO, V.FECHA_VENTA;";
        try{
            motorsql.connect();
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while (rs.next()){
                data.setValoracionMedia(rs.getInt("valoracion_media_vendedor"));
                data.setCantidadValoraciones(rs.getInt("cantidad_valoraciones_vendedor"));
                data.setNombreUsuario(rs.getString("vendedor_nick"));
                data.setNombreProducto(rs.getString("producto_nombre"));
                data.setEstadoProducto(rs.getString("estado_del_producto"));
                data.setDescripcionProducto(rs.getString("producto_descripcion"));
                data.setFechaCompra(rs.getString("fecha_de_venta"));
            }
            SQL = "SELECT C.NOMBRE_COLOR\n" +
                    "FROM PRODUCTO_COLOR PC\n" +
                    "         INNER JOIN COLOR C ON PC.ID_COLOR = C.ID_COLOR\n" +
                    "         INNER JOIN PRODUCTO P ON PC.ID_PRODUCTO = P.ID_PRODUCTO\n" +
                    "WHERE P.NOMBRE_PRODUCTO = '"+nombreProducto+"';";
            rs = motorsql.executeQuery(SQL);
            String colores = "";
            while(rs.next()){
                colores+= rs.getString("nombre_color") + " ";
            }
            data.setColoresProducto(colores);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return data;

    }
}
