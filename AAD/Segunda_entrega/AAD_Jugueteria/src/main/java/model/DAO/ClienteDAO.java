package model.DAO;

import java.sql.ResultSet;

import model.beans.Cliente;
import model.MotorOracle;

public class ClienteDAO {

    MotorOracle motorOracle;

    public ClienteDAO() {
        motorOracle = new MotorOracle();
    }

    public String exportarXMLCliente() {

        // motorOracle.connect();

        // String SQL = "SELECT * FROM CLIENTE ";
        // ResultSet rs = motorOracle.executeQuery(SQL);

        // while (rs.next()) {
        // Cliente cliente = new Cliente();
        // cliente.setId(rs.getInt(0));
        // cliente.setUsuario(rs.getString(1));
        // cliente.setPass(rs.getString(2));
        // cliente.setTlf(rs.getString(3));
        // cliente.setNombre(rs.getString(4));
        // cliente.setApellido_1(rs.getString(5));
        // cliente.setApellido_2(rs.getString(6));
        // cliente.setEmail(rs.getString(7));
        // Cliente.getLstClientes().add(cliente);
        // }

        Cliente cliente = new Cliente();
        cliente.setId(0);
        cliente.setUsuario("pinchauvas");
        cliente.setPass("1234");
        cliente.setTlf("976717171");
        cliente.setNombre("Mario");
        cliente.setApellido_1("Torralba");
        cliente.setApellido_2("Pardos");
        cliente.setEmail("torralba1995@gmail.com");
        Cliente.getLstClientes().add(cliente);

        Cliente cliente2 = new Cliente();
        cliente2.setId(0);
        cliente2.setUsuario("pinchauvas");
        cliente2.setPass("1234");
        cliente2.setTlf("976717171");
        cliente2.setNombre("Mario");
        cliente2.setApellido_1("Torralba");
        cliente2.setApellido_2("Pardos");
        cliente2.setEmail("torralba1995@gmail.com");
        Cliente.getLstClientes().add(cliente2);

        String XML = "<CLIENTE>\n";

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

        return XML;
    }

}
