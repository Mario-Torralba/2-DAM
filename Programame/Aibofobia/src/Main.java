import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(sc.hasNext()){

            char[]palabra = sc.next().toCharArray();
            ArrayList<Character> letras = new ArrayList<>();
            ArrayList<Character> letrasInvertidas = new ArrayList<>();

            int coincidencias = 0;
            int letrasQueFaltan = 0;

            for (int i = 0; i < palabra.length; i++) {

                int tempCoincidencia = 0;
                int tempLetrasQueFaltan = 0;

                for (int j = i; j < palabra.length; j++) {
                    letras.add(palabra[j]);
                    System.out.print(palabra[j]);
                }
                System.out.println();
                for (int j = i; j > -1; j--) {
                    letrasInvertidas.add(palabra[j]);
                    System.out.print(palabra[j]);
                }
                if(letrasInvertidas.size()>letras.size()-1){
                    for (int j = 0; j < letrasInvertidas.size(); j++) {
                        try{
                            if(letrasInvertidas.get(j) == letras.get(j)){
                                tempCoincidencia++;
                            }else{
                                tempLetrasQueFaltan++;
                            }
                        }catch(Exception ex){
                            tempLetrasQueFaltan++;
                        }
                    }
                }else{
                    for (int j = 0; j < letras.size()-1; j++) {
                        try{
                            if(letrasInvertidas.get(j) == letras.get(j)){
                                tempCoincidencia++;
                            }else{
                                tempLetrasQueFaltan++;
                            }
                        }catch(Exception ex){
                            tempLetrasQueFaltan++;
                        }
                    }
                }

                if(coincidencias<tempCoincidencia){
                    coincidencias = tempCoincidencia;
                    letrasQueFaltan = tempLetrasQueFaltan;
                }

                letras.clear();
                letrasInvertidas.clear();

            }
            System.out.println(letrasQueFaltan);
        }
    }
}