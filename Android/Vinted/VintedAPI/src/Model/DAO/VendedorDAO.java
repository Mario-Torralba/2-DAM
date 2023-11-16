package Model.DAO;

import Model.Beans.IdProducto;
import Model.Beans.Mensaje;
import Model.Beans.Producto;
import Model.Beans.Usuario;
import Model.MotorSQL.MotorSQL;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class VendedorDAO {

    MotorSQL motorsql;
    String SQL;

    public VendedorDAO(){
        motorsql = new MotorSQL();
    }
    public ArrayList<Usuario> verTOP10Vendedores(){
        ArrayList<Usuario> lstUsuarios = new ArrayList<>();
        SQL = "SELECT U.ID_USUARIO, U.NOMBRE_USUARIO, U.APELLIDO_1_USUARIO, U.APELLIDO_2_USUARIO, COUNT(*) AS NUMERO_DE_COMPRAS\n" +
                "FROM VENTA V\n" +
                "JOIN USUARIO U ON V.ID_USUARIO_COMPRADOR = U.ID_USUARIO\n" +
                "GROUP BY U.ID_USUARIO, U.NOMBRE_USUARIO, U.APELLIDO_1_USUARIO, U.APELLIDO_2_USUARIO\n" +
                "ORDER BY NUMERO_DE_COMPRAS DESC\n" +
                "LIMIT 3;\n";
        try{
            motorsql.connect();
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
               /* usuario.setNick(rs.getString(2));
                usuario.setPass(rs.getString(3));
                usuario.setTlf_usuario(rs.getString(4));*/
                usuario.setNombre_usuario(rs.getString(2));
                usuario.setApellido_1_usuario(rs.getString(3));
                usuario.setApellido_2_usuario(rs.getString(4));
                usuario.setNumeroVentas(rs.getInt(5));
                //usuario.setEmail_usuario(rs.getString(8));
                lstUsuarios.add(usuario);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            motorsql.disconnect();
        }
        return lstUsuarios;
    }
    public ArrayList<Producto> mostrarMisProductos(String id){
        int idNum = Integer.parseInt(id);
        System.out.println(idNum);
        ArrayList<Producto> lstProducto = new ArrayList<>();
        SQL = "SELECT * FROM PRODUCTO WHERE ID_USUARIO = ?";
        try{
            motorsql.connect();
            PreparedStatement sentencia = motorsql.conn.prepareStatement(SQL);
            sentencia.setInt(1,idNum);
            System.out.println(sentencia);
            ResultSet rs = sentencia.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt(1));
                producto.setId_usuario(rs.getInt(2));
                producto.setId_estado(rs.getInt(3));
                producto.setNombreProducto(rs.getString(4));
                producto.setDescripcionProducto(rs.getString(5));
                producto.setMarcaProducto(rs.getString(6));
                producto.setPrecioProducto(rs.getInt(7));
                producto.setImagenProducto(rs.getString(8));
                lstProducto.add(producto);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return lstProducto;
    }

    public Mensaje crearProducto(String id, String estado, String nombre, String descripcion, String marca, String precio, String imagen){
        int idNum = Integer.parseInt(id);
        int estadoNum = Integer.parseInt(estado);
        int precioNum = Integer.parseInt(precio);
        Mensaje mensaje = new Mensaje();
        mensaje.setMessage("Algo ha salido mal");
        SQL = "INSERT INTO PRODUCTO (ID_USUARIO, ID_ESTADO, NOMBRE_PRODUCTO, DESCRIPCION_PRODUCTO, MARCA_PRODUCTO, PRECIO_PRODUCTO, IMAGEN_PRODUCTO) VALUES (?,?,?,?,?,?,?)";
        try{
            motorsql.connect();
            PreparedStatement sentencia = motorsql.conn.prepareStatement(SQL);
            sentencia.setInt(1,idNum);
            sentencia.setInt(2,estadoNum);
            sentencia.setString(3,nombre);
            sentencia.setString(4,descripcion);
            sentencia.setString(5,marca);
            sentencia.setInt(6,precioNum);
            sentencia.setString(7,imagen);

            System.out.println(sentencia);
            int numero = sentencia.executeUpdate();
            mensaje.setMessage("El producto se ha creado con exito");

        }catch(Exception ex) {
            mensaje.setMessage("Algo ha salido mal");
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return mensaje;
    }

    public IdProducto recuperarId(String nombre){

        IdProducto idProducto = new IdProducto();
        SQL = "SELECT ID_PRODUCTO FROM PRODUCTO WHERE NOMBRE_PRODUCTO LIKE '" + nombre + "' ";
        try{
            motorsql.connect();
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while (rs.next()){
                idProducto.setId(rs.getInt(1));
            }
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return idProducto;
    }

    public Mensaje asociarCategorias(String id_producto, String id_categoria){

        int idproductonum = Integer.parseInt(id_producto);
        int idcategorianum= Integer.parseInt(id_categoria);

        Mensaje mensaje = new Mensaje();
        SQL = "INSERT INTO PRODUCTO_CATEGORIA(ID_PRODUCTO, ID_CATEGORIA) VALUES(" + id_producto +"," + id_categoria + ")";
        try{
            motorsql.connect();
            System.out.println(SQL);
            int salida = motorsql.execute(SQL);
            mensaje.setMessage("CATEGORIA ASOCIADA");
        }catch(Exception ex) {
            mensaje.setMessage("ALGO HA FALLADO");
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return mensaje;
    }

    public Mensaje asociarColores(String id_producto, String id_color){

        int idproductonum = Integer.parseInt(id_producto);
        int idcolornum= Integer.parseInt(id_color);

        Mensaje mensaje = new Mensaje();
        SQL = "INSERT INTO PRODUCTO_COLOR(ID_PRODUCTO, ID_COLOR) VALUES(" + id_producto +"," + id_color + ")";
        try{
            motorsql.connect();
            System.out.println(SQL);
            int salida = motorsql.execute(SQL);
            mensaje.setMessage("COLOR ASOCIADO");
        }catch(Exception ex) {
            mensaje.setMessage("ALGO HA FALLADO");
            System.out.println(ex.getMessage());
        }finally{
            motorsql.disconnect();
        }
        return mensaje;
    }

}
