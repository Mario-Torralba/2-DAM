import Model.Beans.Producto;
import Model.Beans.Usuario;
import Model.DAO.VendedorDAO;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ////////////////////////////////////////////////////////////////////////
        // PRUEBA PARA VER LOS 10 CON MAS VENTAS
        ////////////////////////////////////////////////////////////////////////

        VendedorDAO vendedor = new VendedorDAO();
        ArrayList<Usuario> lstUsuarios = vendedor.verTOP10Vendedores();

        Gson gson = new Gson();
        String json = gson.toJson(lstUsuarios);
        System.out.println(json);

        ////////////////////////////////////////////////////////////////////////
        // PRUEBA PARA VER TODOS LOS PRODUCTOS DEL VENDEDOR
        ////////////////////////////////////////////////////////////////////////

        /*VendedorDAO vendedor = new VendedorDAO();
        ArrayList<Producto> lstProducto = new ArrayList<>();
        lstProducto = vendedor.mostrarMisProductos("2");

        Gson gson = new Gson();
        String json = gson.toJson(lstProducto);

        System.out.println(json);*/

        ////////////////////////////////////////////////////////////////////////
        // PRUEBA PARA CREAR PRODUCTOS
        ////////////////////////////////////////////////////////////////////////

        /*int usuario;
        String nombre;
        String descripcion;
        String marca;
        int precio;
        String imagen;
        int estado;

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Introduce el usuario");
        usuario = sc.nextInt();
        System.out.println("Introduce el estado");
        estado = sc.nextInt();
        System.out.println("Introduce el nombre");
        nombre = sc.next();
        System.out.println("Introduce el descripcion");
        descripcion = sc.next();
        System.out.println("Introduce el marca");
        marca = sc.next();
        System.out.println("Introduce el precio");
        precio = sc.nextInt();
        System.out.println("Introduce el imagen");
        imagen = sc.next();

        VendedorDAO vendedor = new VendedorDAO();
        System.out.println(vendedor.crearProducto(usuario,estado,nombre,descripcion,marca,precio,imagen));*/

    }

}