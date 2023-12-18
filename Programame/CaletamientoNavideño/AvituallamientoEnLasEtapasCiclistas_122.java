import java.util.Scanner;

public class ProblemasDeHerencia_103{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            int posicion = 0;
            int posicionTemp = 0;
            int distancia = 0;
            int distanciaTemp = 0;

            String salida = sc.nextLine();
            if (salida == "-1") {
                break;
            }
            String [] numeros = salida.split(" ");


            for (int i = 0; i < numeros.length; i++) {
                
                if (i!= 0) {
                    if(numeros[i] == numeros[i-1]){
                        distanciaTemp++;
                    }else{
                        if(distanciaTemp > distancia){

                            distancia = distanciaTemp;
                        }
                        distanciaTemp = 0;
                    }
                }
                if(numeros[i] == numeros[i+1]){
                    posicionTemp = i + 1;
                }

                
            }
            System.out.println(distancia);
            System.out.println(posicion);
        }

    }
 }