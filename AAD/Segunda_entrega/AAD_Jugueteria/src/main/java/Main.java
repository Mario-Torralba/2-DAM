
import java.sql.ResultSet;
import java.util.Scanner;

import model.beans.Cliente;
import model.MotorOracle;
import model.DAO.ClienteDAO;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] tablas = { "CLIENTES",
                "PEDIDO",
                "DETALLE_PEDIDO",
                "ALBARAN_CLIENTE",
                "DETALLE_ALBARAN_CLIENTE",
                "DIRECCION_CLIENTE",
                "FACTURA_ALBARAN_CLIENTE",
                "TICKET",
                "PAGO_TARJETA",
                "DETALLE_TICKET",
                "PRODUCTO",
                "PARTICULAR",
                "PRODUCTO_PARTICULAR",
                "NOTA_PAGO",
                "DETALLE_NOTA_PAGO",
                "PROVEEDOR",
                "HOJA_PEDIDO",
                "ALBARAN",
                "FACTURA",
                "DETALLE_HOJA_PEDIDO",
                "DETALLE_ALBARAN"
        };

        System.out.println("¿Que quieres hacer?");
        System.out.println("1 - Importar XML");
        System.out.println("2 - Exportar XML");

        int decision = sc.nextInt();

        if (decision == 1) {
            // IMPORTAR
            System.out.println("Elige el archivo a importar: ");
        } else {
            // EXPORTAR
            System.out.println("Elige la tabla a exportar (SOLO FUNCIONA LA TABLA CLIENTES): ");
            for (int i = 0; i < tablas.length; i++) {
                System.out.println(i + 1 + " - " + tablas[i]);
            }
            decision = sc.nextInt();
            if (decision == 1) {
                ClienteDAO cliente = new ClienteDAO();
                String XML = cliente.exportarXMLCliente();
                System.out.println(XML);
            }
        }
    }

    

    public static void importarXMLCliente() {

    }
}