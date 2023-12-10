package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MotorOracle {

    private Connection conn;
    public Connection getConn() {
        return conn;
    }
    private Statement st;
    private ResultSet rs;

    //conn sys as sysdba

    // create user z identified by z;

    // grant connect to z;
    // grant resource to z;

    // connect
    // z
    // z

    // SET SERVEROUTPUT ON;
    
    //private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    
    private static final String URL = "jdbc:postgresql://aad.c1kmifussq1f.us-east-1.rds.amazonaws.com:5432/aad";


    public void connect() {
        System.out.println(DriverManager.getDrivers().toString());
        try {

            conn = DriverManager.getConnection(URL, "mario", "");

            st = conn.createStatement();

        } catch (SQLException ex) {
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
            System.out.println("Ha habido un error: " + ex.getMessage());
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
    public static void main(String[] args) {
        MotorOracle motorOracle = new MotorOracle();
        motorOracle.connect();
    }

}
