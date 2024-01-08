import java.util.Scanner;

/**
 * LosSaltosDeMario
 */
public class LosSaltosDeMario {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cantidad = sc.nextInt();

        for (int i = 0; i < cantidad; i++) {
        
            int saltoArriba = 0;
            int saltoAbajo = 0;

            int cantidad2 = sc.nextInt();
            int[] resultado = new int[cantidad2];

            for (int j = 0; j < cantidad2; j++) {
                
                resultado[j] = sc.nextInt();
                if(j!=0){
                    if(resultado[j]<resultado[j-1]){
                        saltoArriba++;
                    }
                    if(resultado[j]>resultado[j-1]){
                        saltoAbajo++;
                    }
                }
            }

            System.out.println(saltoAbajo + " " + saltoArriba);
        }
    }
}