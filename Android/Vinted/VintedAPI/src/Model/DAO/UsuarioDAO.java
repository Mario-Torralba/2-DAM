package Model.DAO;

import Model.Beans.Busqueda.DataProducto;
import Model.Beans.Busqueda.Producto;
import Model.Beans.Mensaje;
import Model.Beans.VerValoraciones.DataUsuarioValoracion;
import Model.Beans.VerValoraciones.UsuarioValoraciones;
import Model.MotorSQL.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLOutput;

public class UsuarioDAO {

    MotorSQL motorsql;
    String SQL;

    public UsuarioDAO(){
        motorsql = new MotorSQL();
    }

    public Mensaje userLogin(String nick, String pass){
        Mensaje mensaje = new Mensaje();
        mensaje.setMessage("LOGIN INCORRECTO");
        try{
            motorsql.connect();
            SQL = "SELECT * FROM USUARIO WHERE nick LIKE '" + nick + "' AND pass LIKE '" + pass + "'; ";
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                mensaje.setMessage("LOGIN CORRECTO");

            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            mensaje.setMessage("LOGIN INCORRECTO");
        }finally {
            motorsql.disconnect();
        }
        return mensaje;
    }

    public Mensaje valorarVendedor(String atribs, String estrellas, String comentario){
        Mensaje mensaje = new Mensaje();
        mensaje.setMessage("VALORACION ERRONEA");
        String[]atributos = atribs.split("\\ ");
        String nombre = atributos[0].toLowerCase();
        String apellido_1 = atributos[1].toLowerCase();
        String apellido_2 = atributos[2].toLowerCase();
        System.out.println(nombre);
        int id_usuario = 0;
        SQL= "SELECT ID_USUARIO FROM USUARIO WHERE lower(NOMBRE_USUARIO) LIKE '%" + nombre +"%'" +
                "AND lower(APELLIDO_1_USUARIO) LIKE '%" + apellido_1 +"%'" +
                "AND lower(APELLIDO_2_USUARIO) LIKE '%" + apellido_2 + "%'";
        try{
            motorsql.connect();
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                id_usuario = rs.getInt(1);
            }
            SQL="INSERT INTO VALORACION(ID_USUARIO, ESTRELLAS, COMENTARIO) VALUES (" + id_usuario + ","+ estrellas +",'"+ comentario +"')";
            int salida = motorsql.execute(SQL);
            mensaje.setMessage("TODO DE PERLAS");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            mensaje.setMessage("LOGIN INCORRECTO");
        }finally {
            motorsql.disconnect();
        }
        return mensaje;
    }

    public DataUsuarioValoracion verValoraciones(){
        DataUsuarioValoracion data = new DataUsuarioValoracion();
        data.setMessage("VER VALORACIONES SUFRIO UN CAGADON APOTEÓSICO");
        try{
            motorsql.connect();
            SQL = "SELECT\n" +
                    "    U.NOMBRE_USUARIO,\n" +
                    "    U.APELLIDO_1_USUARIO,\n" +
                    "    U.APELLIDO_2_USUARIO,\n" +
                    "    U.EMAIL_USUARIO,\n" +
                    "    U.TLF_USUARIO,\n" +
                    "    AVG(V.ESTRELLAS) AS MEDIA_ESTRELLAS\n" +
                    "FROM\n" +
                    "    USUARIO U\n" +
                    "        JOIN\n" +
                    "    VALORACION V ON U.ID_USUARIO = V.ID_USUARIO\n" +
                    "GROUP BY\n" +
                    "    U.ID_USUARIO,\n" +
                    "    U.NOMBRE_USUARIO,\n" +
                    "    U.APELLIDO_1_USUARIO,\n" +
                    "    U.APELLIDO_2_USUARIO,\n" +
                    "    U.EMAIL_USUARIO,\n" +
                    "    U.TLF_USUARIO\n" +
                    "order by MEDIA_ESTRELLAS DESC;";
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                UsuarioValoraciones usuarioValoraciones = new UsuarioValoraciones();
                usuarioValoraciones.setNombre_apellidos(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
                usuarioValoraciones.setEmail(rs.getString(4));
                usuarioValoraciones.setTelefono(rs.getString(5));
                usuarioValoraciones.setEstrellas(rs.getFloat(6));
                data.getLstUsuarios().add(usuarioValoraciones);
            }
            data.setMessage("TODO DE PERLAS");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            motorsql.disconnect();
        }
        return data;
    }

    public DataProducto busqueda(String categoria, String color, String busqueda){
        DataProducto dataProducto = new DataProducto();
        dataProducto.setMessage("CAGADON APOTEOSICO");
        try{
            motorsql.connect();
            SQL = "SELECT P.ID_PRODUCTO, P.ID_USUARIO, P.id_estado, P.NOMBRE_PRODUCTO, P.descripcion_producto, P.marca_producto, P.precio_producto, COUNT(*)\n" +
                    "FROM PRODUCTO P\n" +
                    "         JOIN PRODUCTO_CATEGORIA PC ON P.ID_PRODUCTO = PC.ID_PRODUCTO\n" +
                    "         JOIN CATEGORIA C ON PC.ID_CATEGORIA = C.ID_CATEGORIA\n" +
                    "         JOIN PRODUCTO_COLOR PCO ON P.ID_PRODUCTO = PCO.ID_PRODUCTO\n" +
                    "         JOIN COLOR CO ON PCO.ID_COLOR = CO.ID_COLOR WHERE 1 = 1 \n";
            if(categoria.equals("CATEGORIA")){
            }else{
                SQL += "AND C.NOMBRE_CATEGORIA = '" + categoria + "'\n";
            }
            if(color.equals("COLOR")){
            }else{
                SQL += "  AND CO.NOMBRE_COLOR = '"+ color +"'\n";
            }
            SQL += "  AND P.NOMBRE_PRODUCTO LIKE '%"+ busqueda +"%'\n";
            SQL += "GROUP BY P.ID_PRODUCTO, P.ID_USUARIO, P.id_estado, P.NOMBRE_PRODUCTO, P.descripcion_producto, P.marca_producto, P.precio_producto;";

            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt(1));
                producto.setId_usuario(rs.getInt(2));
                producto.setId_estado(rs.getInt(3));
                producto.setNombre_producto(rs.getString(4));
                producto.setDescripcion_producto(rs.getString(5));
                producto.setMarca_producto(rs.getString(6));
                producto.setPrecio_producto(rs.getInt(7));
                dataProducto.getLstProducto().add(producto);
            }
            dataProducto.setMessage("TODO PERLAS");
        }catch(Exception ex){
            System.out.println(ex.getMessage());

        }finally {
            motorsql.disconnect();
        }
        return dataProducto;
    }

}
