package api.controller;

import api.model.ProductAction;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.printf("1 - Dar de alta producto");
        System.out.printf("2 - Dar de baja producto");
        System.out.printf("3 - Listar productos");
        System.out.printf("4 - Modificar productos");

        Scanner sc = new Scanner(System.in);
        int respuesta = sc.nextInt();

        switch (respuesta){

            case 1:
                System.out.println("\nHas introducido dar de alta el producto\n");
                System.out.println("Introduce el nombre del producto\n");
                String nombreProducto = sc.nextLine();
                System.out.println("Introduce el precio del producto.\n");
                int precioProducto = sc.nextInt();
                new ProductAction().altaProducto(nombreProducto,precioProducto);
                break;
            case 2:
                System.out.println("\nHas introducido dar de baja el producto\nIntroduce el ID de producto");
                int idBaja = sc.nextInt();
                new ProductAction().bajaProducto(idBaja);
                break;
            case 3:
                new ProductAction().listarProductos();
            case 4:
                System.out.println("\nHas introducido modificar el producto\nIntroduce el ID de producto");
                int idModificacion = sc.nextInt();
                System.out.println("Introduce el nombre del producto\n");
                String nombreModificar = sc.nextLine();
                System.out.println("Introduce el precio del producto.\n");
                int precioModificar = sc.nextInt();
                new ProductAction().modificarProducto(idModificacion,nombreModificar,precioModificar);
                break;

        }
    }
}