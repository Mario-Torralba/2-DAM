package Model.DAO;

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
            SQL = "";
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                UsuarioValoraciones usuarioValoraciones = new UsuarioValoraciones();
                usuarioValoraciones.setNombre_apellidos(rs.getString(0));
                usuarioValoraciones.setEmail(rs.getString(0));
                usuarioValoraciones.setTelefono(rs.getString(0));
                usuarioValoraciones.setEstrellas(rs.getInt(0));
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

}
