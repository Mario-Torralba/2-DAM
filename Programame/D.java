import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D{
    public static void main(String[] args) throws IOException {
        

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        
        int iteraciones = Integer.parseInt(in.readLine().trim());
        System.out.println();

        String[][] primeraEntrada = new String [iteraciones][2];

        for (int i = 0; i < iteraciones; i++) {
            
            primeraEntrada[i] = in.readLine().split(","); 
        }

        int iteraciones2 = Integer.parseInt(in.readLine().trim());

        for (int i = 0; i < iteraciones2; i++) {
            boolean conseguido = false;
            String base = in.readLine();
            String raiz = "";
            String sinhttp = base.split("//")[1];
            if(sinhttp.substring(0, 3).equals("www")){
                String [] base2 = base.split("www.");
                base = base2[0] + base2[1];
                String [] sinwww = sinhttp.split("www.");
                raiz = sinwww[1];
            }else{
                raiz = sinhttp;
            }
            // System.out.println(raiz);
            String salidaFinal = raiz.split("/")[0];
            for (int j = 0; j < primeraEntrada.length; j++) {
                if(salidaFinal.equals(primeraEntrada[j][0])){
                    String[] salidafinal2 = base.split(salidaFinal);
                    sb.append(salidafinal2[0]).append(primeraEntrada[j][1]).append(salidafinal2[1]).append("\n");
                    // System.out.println(salidafinal2[0] + primeraEntrada[j][1] + salidafinal2[1]);
                    conseguido = true;
                }
            }
            if(!conseguido){
                sb.append("No se puede resolver el dominio ").append(salidaFinal).append("\n");

            }
            // System.out.println(sinhttp);
            // System.out.println(sinwww);
            // System.out.println(raiz);
        }


  
        out.write(sb.toString());
        out.flush();

    }
}