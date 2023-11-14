package Model.DAO;

import Model.Beans.Mensaje;
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
        mensaje.setMensaje("LOGIN INCORRECTO");
        try{
            motorsql.connect();
            SQL = "SELECT * FROM USUARIO WHERE nick LIKE '" + nick + "' AND pass LIKE '" + pass + "'; ";
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                mensaje.setMensaje("LOGIN CORRECTO");

            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            mensaje.setMensaje("LOGIN INCORRECTO");
        }finally {
            motorsql.disconnect();
        }
        return mensaje;
    }

}
