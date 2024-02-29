import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class H {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> corredores = new HashMap<>();

        int numCorredores = Integer.parseInt(in.readLine());
        int[] tiempos = new int[numCorredores];



        int contadorT = 0;

        String line;

        for (int i = 0; i < numCorredores; i++) {

            line = in.readLine();
            String[] datos = line.split(":");
            int t = calcularTiempoReal(datos[1], Character.getNumericValue(datos[2].charAt(0)));

            corredores.put(t, datos[0]);
            tiempos[contadorT] = t;
            contadorT++;

        }

        Arrays.sort(tiempos);

        for (int i = 0; i < tiempos.length; i++) {
            sb.append(corredores.get(tiempos[i]));
        }

        out.write(sb.toString());
        out.flush();
    }

    private static int calcularTiempoReal(String t, int mins) {

        String[] datos = t.split(",");
        int tiempo = Integer.parseInt(datos[0]) * 60 + Integer.parseInt(datos[1]) - mins;
        return tiempo;

    }
}