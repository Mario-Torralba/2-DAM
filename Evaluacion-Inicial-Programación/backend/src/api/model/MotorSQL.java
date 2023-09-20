package api.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MotorSQL {

    private Connection conn;
    private Statement st;
    private ResultSet rs;


    // private static final String URL = "jdbc:derby://localhost:1527/cafeteria";
    // private static String driver = "mysql";
    // private static String hostname = "database-2.ccmhlh5el4hp.us-east-1.rds.amazonaws.com";
    // private static String port = "3306";
    // private static String dbName = "MainDB";
    // private static String userName = "admin";
    // private static String password = "admin123";
    // private static final String CONTROLADOR = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_NAME = ":orcl";
   
    private static final String DB_HOSTNAME = "orcl.c1kmifussq1f.us-east-1.rds.amazonaws.com";
    private static final String DB_PORT = ":1521";

    private static final String JDBC_URL = "jdbc:oracle:thin:@" + DB_HOSTNAME + DB_PORT + DB_NAME;

    public void connect() {
        System.out.println(DriverManager.getDrivers().toString());
        try {
            //conn = DriverManager.getConnection(URL);
            conn = DriverManager.getConnection(JDBC_URL,"admin","12341234");


            st = conn.createStatement();
            //} catch (ClassNotFoundException ex) {
            // System.out.println(ex.getMessage());
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int execute(String sql) {
        int resp = 0;
        try {
            resp = st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resp;
    }

    public ResultSet executeQuery(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("ha habido un error: " + ex.getMessage());
        }
        return rs;
    }

    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args){
        MotorSQL a = new MotorSQL();
        a.connect();
    }
}
