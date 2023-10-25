import interfaz.MyInterface;
import interfaz.Presenter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MyInterface mipresentador = new Presenter();

        Thread hilo = new Thread(){
          Scanner input = new Scanner(System.in);
          int inputValue = 0;
          while(true){
                System.out.println("Simula un 0 - Correcto");
                System.out.println("Simula un 1 - Incorrecto");
                System.out.println("Dame un valor:");
                if(inputValue==0){
                    System.out.println("Success");
                    mipresentador.mostrarLoginCorrecto();
                }else{
                    System.out.println("Failure");
                    mipresentador.mostrarLoginIncorrecto();
                }
            }
        };

    }
}