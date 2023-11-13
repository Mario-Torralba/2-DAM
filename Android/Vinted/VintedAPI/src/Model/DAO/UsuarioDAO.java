package Model.DAO;

import Model.MotorSQL.MotorSQL;

import java.sql.ResultSet;
import java.sql.SQLOutput;

public class UsuarioDAO {

    MotorSQL motorsql;
    String SQL;

    public UsuarioDAO(){
        motorsql = new MotorSQL();
    }

    public String userLogin(String nick, String pass){
        String salida = "LOGIN INCORRECTO";
        try{
            motorsql.connect();
            SQL = "SELECT * FROM USUARIO WHERE nick LIKE '" + nick + "' AND pass LIKE '" + pass + "'; ";
            System.out.println(SQL);
            ResultSet rs = motorsql.executeQuery(SQL);
            while(rs.next()){
                salida = "LOGIN CORRECTO";
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            salida = "LOGIN INCORRECTO";
        }finally {
            motorsql.disconnect();
        }
        return salida;
    }

}
