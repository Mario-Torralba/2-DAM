
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

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

        System.out.println("¿Que quieres hacer?(Escribir el número)");
        System.out.println("1 - Importar XML");
        System.out.println("2 - Exportar XML");

        int decision = sc.nextInt();

        if (decision == 1) {
            // IMPORTAR
            // RECUPERAR LOS ARCHIVOS DE LA CARPETA DE XMLS
            String[] archivos = getFileNames(
                    ".\\xmls");
            System.out.println("Elige el archivo a importar:(Escribir el número) ");
            int contador = 1;
            for (String e : archivos) {
                System.out.println(contador + " - " + e);
                contador++;
            }
            decision = sc.nextInt();
            transformarXML(archivos[decision - 1]);
        } else {
            // EXPORTAR
            System.out.println("Elige la tabla a exportar (SOLO FUNCIONA LA TABLA CLIENTES):(Escribir el número) ");
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

    public static void transformarXML(String nombreArchivo) {

        String filePath = ".\\xmls\\"
                + nombreArchivo; // Reemplaza con la ruta de tu archivo XML

        try {

            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }

            bufferedReader.close();
            fileReader.close();

            String xml = stringBuilder.toString();
            crearQuery(xml);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void crearQuery(String xml) {

        // CUENTA LA CANTIDAD DE CLIENTES EN EL XML PARA LUEGO PODER HACER UN BUCLE Y CREAR UN OBJETO CLIENTE DE CADA UNO

        int contadorCliente = 0;
        int indice = xml.indexOf("<Cliente>");

        while (indice != -1) {
            contadorCliente++;
            indice= xml.indexOf("<Cliente>",indice+1);
        }
    
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new java.io.ByteArrayInputStream(xml.getBytes()));

            // CREACION DEL OBJETO
            for (int i = 0; i < contadorCliente; i++) {
                Cliente cliente = new Cliente();
                cliente.setId(Integer.parseInt(doc.getElementsByTagName("ID_CLIENTE").item(i).getTextContent()));
                cliente.setUsuario(doc.getElementsByTagName("USUARIO").item(i).getTextContent());
                cliente.setPass(doc.getElementsByTagName("PASS").item(i).getTextContent());
                cliente.setTlf(doc.getElementsByTagName("TLF").item(i).getTextContent());
                cliente.setNombre(doc.getElementsByTagName("NOMBRE").item(i).getTextContent());
                cliente.setApellido_1(doc.getElementsByTagName("APELLIDO_1").item(i).getTextContent());
                cliente.setApellido_2(doc.getElementsByTagName("APELLIDO_2").item(i).getTextContent());
                cliente.setEmail(doc.getElementsByTagName("EMAIL").item(i).getTextContent());
                Cliente.getLstClientes().add(cliente);              
            }
            for (Cliente e : Cliente.getLstClientes()) {
                System.out.println(e.toString());
            }
            ClienteDAO clientedao = new ClienteDAO();
            clientedao.XMLquery();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void escribirArchivoXML(String XML) {

        File fichero = null;
        FileWriter writer = null;
        PrintWriter pw = null;
        try {
            fichero = new File(
                    ".\\xmls");
            writer = new FileWriter(fichero + "\\cliente.xml");
            pw = new PrintWriter(writer);
            pw.println(XML);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    writer.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String[] getFileNames(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        ArrayList<String> listaArchivos = new ArrayList<String>();
        for (File archivo : carpeta.listFiles())
            listaArchivos.add(archivo.getName());
        return (listaArchivos.toArray(new String[0]));
    }
}