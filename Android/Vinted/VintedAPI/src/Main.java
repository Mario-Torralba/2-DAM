import Model.DAO.VendedorDAO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int usuario;
        String nombre;
        String descripcion;
        String marca;
        int precio;
        String imagen;
        String estado;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el usuario");
        usuario = sc.nextInt();
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
        System.out.println("Introduce el estado");
        estado = sc.nextLine();

        VendedorDAO vendedor = new VendedorDAO();
        System.out.println(vendedor.crearProducto(usuario,nombre,descripcion,marca,precio,imagen,estado));

    }

}
