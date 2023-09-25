package api.controller;

import java.util.Scanner;

import api.controller.action.ProductAction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int respuesta = 0;

        while(respuesta!=5){

            System.out.println("\n1 - Dar de alta producto");
            System.out.println("2 - Dar de baja producto");
            System.out.println("3 - Listar productos");
            System.out.println("4 - Modificar productos");
            System.out.println("5 - Salir\n");

            respuesta = sc.nextInt();

            switch (respuesta){

                case 1:
                    System.out.println("\nHas introducido dar de alta el producto");

                    System.out.println("Introduce el id del proveedor (1 al 6):\n");
                    String idProveedor = sc.next();
                    System.out.println("Introduce el nombre del producto:\n");
                    String nombreProducto = sc.next();
                    System.out.println("Introduce el precio del producto:\n");
                    int precioProducto = sc.nextInt();

                    new ProductAction().altaProducto(idProveedor,nombreProducto,precioProducto);
                    break;
                case 2:
                    System.out.println("\nHas introducido dar de baja el producto\nIntroduce el ID de producto");
                    int idBaja = sc.nextInt();
                    new ProductAction().bajaProducto(idBaja);
                    break;
                case 3:
                    new ProductAction().listarProductos();
                    break;
                case 4:
                    System.out.println("\nHas introducido modificar el producto\nIntroduce el ID de producto");
                    int idModificacion = sc.nextInt();
                    System.out.println("Introduce el nombre del producto\n");
                    String nombreModificar = sc.next();
                    System.out.println("Introduce el precio del producto.\n");
                    int precioModificar = sc.nextInt();
                    new ProductAction().modificarProducto(idModificacion,nombreModificar,precioModificar);
                    break;

            }

        }

        //**********************************************
        //*******          EJERCICIO 8          ********
        //**********************************************

        // ES UN FORMATO DE TEXTO PARA EL INTERCAMBIO DE DATOS
        // LA TRADUCCION DE LOS JSON A JAVA SERIA:
        // CLASE ESTABLECIMIENTO CON UN ARRAYLIST DE TIPO_PRODUCTO Y CADA TIPO PRODUCTO CON SU PROPIO ARRAYLIST DE PRODUCTO
        // FRUTERIA (CLASE ESTABLECIMIENTO) CONTIENE ARRAYLIST DE FRUTA (CLASE TIPO_PRODUCTO) CLASE QUE CONTIENE SU ARRAYlIST DE FRUTAS (CLASE PRODUCTO)
    }
}