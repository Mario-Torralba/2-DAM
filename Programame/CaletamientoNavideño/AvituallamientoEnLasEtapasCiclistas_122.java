import java.util.Scanner;

public class AvituallamientoEnLasEtapasCiclistas_122{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            int posicion = 0;
            int posicionTemp = 0;
            int distancia = 0;
            int distanciaTemp = 0;

            String salida = sc.nextLine();
            if (salida.equals("-1")) {
                break;
            }
            String [] numeros = salida.split(" ");


            for (int i = 0; i < numeros.length; i++) {
                
                if (i!= 0) {
                    if(numeros[i].equals(numeros[i-1])){
                        distanciaTemp++;
                    }else{
                        if(distanciaTemp > distancia){

                            distancia = distanciaTemp;
                            posicion = posicionTemp;
                        }
                        distanciaTemp = 0;
                    }
                }
                if(i<numeros.length-1){

                    if(numeros[i].equals(numeros[i+1])){
                        posicionTemp = i + 1;
                    }

                }
                

                
            }
            if((posicion-distancia) == 0 && distancia == 0){
                System.out.println("HOY NO COMEN");
            }else{
                System.out.print(posicion-distancia);
                System.out.println(" " + distancia);
            }

        }

    }
 }