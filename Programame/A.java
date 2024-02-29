import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A{
    public static void main(String[] args) throws IOException {
        

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line;

        String[] dominiosNegros = in.readLine().trim().split(",");
        String[] mensajesNegros = in.readLine().trim().split(",");

        int iteraciones = Integer.parseInt(in.readLine().trim());

        for (int i = 0; i < iteraciones; i++) {
            int puntuacion = 0;
            String[] entrada = in.readLine().split(",");

            String[] correo1 = entrada[1].split(":");
            String remitente = correo1[1];

            String[] correo2 = entrada[2].split(":");
            String destinatario = correo2[1];

            String mensaje = entrada[3];

    
            String prueba = remitente;

            int cantidadArrobas = 0;
            int cantidadPuntos = 0;

            for (int j = 0; j < remitente.length(); j++) {
                if(remitente.charAt(j) == '@'){
                    cantidadArrobas++;
                }
                if(remitente.charAt(j) == '.'){
                    cantidadPuntos++;
                }
            }
            if(cantidadArrobas == 1){
                try {
                    String[] remitenteArray = prueba.split("@");
                    if(remitenteArray[0].length() > 0 && remitenteArray[1].length() > 0){
                        puntuacion+=0;
                    }
                    for (int j = 0; j < dominiosNegros.length; j++) {
                        if(dominiosNegros[j].equals(remitenteArray[1])){
                            puntuacion+=10;
                        }
                    }
                } catch (Exception e) {
                    puntuacion += 3;
                }
            }else{
                puntuacion += 3;
            }
            


            if(cantidadPuntos == 1){
                try {
                    String[] remitenteArray2 = remitente.split("\\.");
                    if(remitenteArray2[1].length()>0){
                        puntuacion+=0;
                    }
                } catch (Exception e) {
                    puntuacion += 3;
                }
            }else{
                puntuacion += 3;
            }


            String[]mensajes = mensaje.split(" ");

            for (int j = 0; j < mensajes.length; j++) {
                for (int j2 = 0; j2 < mensajesNegros.length; j2++) {
                    if(mensajes[j].equals(mensajesNegros[j2])){
                        puntuacion++;
                    }
                }
            }

            sb.append("mail ").append(i + 1).append(" spam score = ").append(puntuacion).append("\n");

        }

        out.write(sb.toString());
        out.flush();

    }
}