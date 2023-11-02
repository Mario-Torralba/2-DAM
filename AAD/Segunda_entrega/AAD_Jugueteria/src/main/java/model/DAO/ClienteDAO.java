package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.beans.Cliente;
import model.MotorOracle;

public class ClienteDAO {

    MotorOracle motorOracle;
    // Connection conn;

    public ClienteDAO() {
        motorOracle = new MotorOracle();
    }

    public String exportarXMLCliente() {
        String XML = "";
        try {
            motorOracle.connect();

            String SQL = "SELECT * FROM CLIENTE ";
            ResultSet rs = motorOracle.executeQuery(SQL);

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setUsuario(rs.getString(2));
                cliente.setPass(rs.getString(3));
                cliente.setTlf(rs.getString(4));
                cliente.setNombre(rs.getString(5));
                cliente.setApellido_1(rs.getString(6));
                cliente.setApellido_2(rs.getString(7));
                cliente.setEmail(rs.getString(8));
                Cliente.getLstClientes().add(cliente);
            }
            XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
            XML += "<CLIENTE>\n";

            for (Cliente e : Cliente.getLstClientes()) {
                XML += "    <Cliente>\n";
                XML += "        <ID_CLIENTE>" + e.getId() + "</ID_CLIENTE>\n";
                XML += "        <USUARIO>" + e.getUsuario() + "</USUARIO>\n";
                XML += "        <PASS>" + e.getPass() + "</PASS>\n";
                XML += "        <TLF>" + e.getTlf() + "</TLF>\n";
                XML += "        <NOMBRE>" + e.getNombre() + "</NOMBRE>\n";
                XML += "        <APELLIDO_1>" + e.getApellido_1() + "</APELLIDO_1>\n";
                XML += "        <APELLIDO_2>" + e.getApellido_2() + "</APELLIDO_2>\n";
                XML += "        <EMAIL>" + e.getEmail() + "</EMAIL>\n";
                XML += "    </Cliente>\n";
            }
            XML += "</CLIENTE>\n";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            motorOracle.disconnect();
        }

        // Cliente cliente = new Cliente();
        // cliente.setId(0);
        // cliente.setUsuario("pinchauvas");
        // cliente.setPass("1234");
        // cliente.setTlf("976717171");
        // cliente.setNombre("Mario");
        // cliente.setApellido_1("Torralba");
        // cliente.setApellido_2("Pardos");
        // cliente.setEmail("torralba1995@gmail.com");
        // Cliente.getLstClientes().add(cliente);

        // Cliente cliente2 = new Cliente();
        // cliente2.setId(0);
        // cliente2.setUsuario("pinchauvas");
        // cliente2.setPass("1234");
        // cliente2.setTlf("976717171");
        // cliente2.setNombre("Mario");
        // cliente2.setApellido_1("Torralba");
        // cliente2.setApellido_2("Pardos");
        // cliente2.setEmail("torralba1995@gmail.com");
        // Cliente.getLstClientes().add(cliente2);

        return XML;
    }

    public void XMLquery() {
        String SQL = "INSERT INTO CLIENTE(USUARIO,PASS,TLF,NOMBRE,APELLIDO_1,APELLIDO_2,EMAIL)VALUES(?,?,?,?,?,?,?) ";
        int salida = 0;
        try {
            motorOracle.connect();
            PreparedStatement statement = motorOracle.getConn().prepareStatement(SQL);
            for (Cliente e : Cliente.getLstClientes()) {
                statement.setString(1, e.getUsuario());
                statement.setString(2, e.getPass());
                statement.setString(3, e.getTlf());
                statement.setString(4, e.getNombre());
                statement.setString(5, e.getApellido_1());
                statement.setString(6, e.getApellido_2());
                statement.setString(7, e.getEmail());
                System.out.println(statement);
                salida = statement.executeUpdate();
            }
        } catch (Exception ex) {
            ex.getMessage();
        } finally {
            motorOracle.disconnect();
        }
    }

}
