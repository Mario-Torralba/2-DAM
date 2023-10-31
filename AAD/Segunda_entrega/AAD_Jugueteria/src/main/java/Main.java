
import java.io.FileWriter;
import java.io.PrintWriter;
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
            if (decision == 1) { // ES UNA CHAPUZA, PERO ES LO QUE HAY
                ClienteDAO cliente = new ClienteDAO();
                String XML = cliente.exportarXMLCliente();
                // ESCRIBIR ARCHIVO
                escribirArchivoXML(XML);

                
            }
        }
    }

    

    public static void escribirArchivoXML(String XML) {

        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("./cli","cliente.xml");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }

    }
}