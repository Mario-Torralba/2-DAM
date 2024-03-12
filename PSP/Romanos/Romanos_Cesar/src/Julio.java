import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Julio extends Thread{

    static final int PUERTO = 5000;

    public DataInputStream in;
    public DataOutputStream out;
    Random random = new Random();
    ServerSocket skServidor;
    Scanner sc = new Scanner(System.in);
    Socket centurion;

    String [] personasMensaje = {"Mario", "Santi", "Dimitri", "Rebeca", "Cristina"};
    String [] cuerpoMensaje = {"Hola", "Adios", "Prestame la PS5", "Parece que va a llover", "Vaya mierda de dia"};
    String [] queVigilar2 = {"Casa", "Campamento", "Torre Eifel", "Patio", "Ovejas"};

    public Julio(){
        try {
            skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho en el puerto: " + PUERTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                conectar();
                darOrden();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                out.close();
                in.close();
                centurion.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void darOrden() throws IOException {

        String accion = accionAleatoria();
        switch (accion){
            case "CERVEZA":
                int litros = random.nextInt(200)+1;
                System.out.println("El CESAR necesita " + litros + " de cerveza");
                out.writeUTF("CERVEZA");
                out.writeInt(litros);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "PRISIONEROS":
                int prisioneros = random.nextInt(5)+1;
                System.out.println("El CESAR necesita interrogar " + prisioneros + " prisioneros");
                out.writeUTF("PRISIONEROS");
                out.writeInt(prisioneros);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "PAPEL":
                int metros = random.nextInt(200)+1;
                System.out.println("El CESAR necesita " + metros + " metros de papel de pergamino");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                out.writeUTF("PAPEL");
                out.writeInt(metros);
                break;
            case "MENSAJE":
                String destinatario = personasMensaje[random.nextInt(4)];
                System.out.println("El CESAR quiere enviar un mensaje a: " + destinatario);
                String cuerpo = cuerpoMensaje[random.nextInt(4)];
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                out.writeUTF("MENSAJE");
                out.writeUTF(destinatario);
                out.writeUTF(cuerpo);
                break;
            case "VIGILANCIA":
                String queVigilar = queVigilar2[random.nextInt(4)];
                int tiempo = random.nextInt(10);
                System.out.println("El CESAR quiere hacer vigilancia en " + queVigilar + " durante " + tiempo + " segundos");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                out.writeUTF("VIGILANCIA");
                out.writeUTF(queVigilar);
                out.writeInt(tiempo);
                break;
        }

    }

    public void conectar() throws IOException {
        centurion = skServidor.accept();

        InputStream is = centurion.getInputStream();
        in = new DataInputStream(is);
        System.out.println(in.readUTF());

        OutputStream aux = centurion.getOutputStream();
        out = new DataOutputStream(aux);
        out.writeUTF("Hola Centurion, aqui el CESAR");
    }

    public String accionAleatoria(){
        int eleccion = random.nextInt(3)+1;
        switch (eleccion){
            case 1:
                eleccion = random.nextInt(3)+1;
                switch (eleccion) {
                    case 1:
                        return "CERVEZA";
                    case 2:
                        return "PRISIONEROS";
                    case 3:
                        return "PAPEL";
                }
            case 2:
                return "MENSAJE";
            case 3:
                return "VIGILANCIA";
        }
        return null;
    }
    public static String encriptar(String mensaje) {
        StringBuilder mensajeEncriptado = new StringBuilder();

        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);

            if (Character.isLetter(caracter)) {
                // Encriptar letras
                char encriptado = (char) (((caracter - 'a' + 3) % 26) + 'a');
                if (Character.isUpperCase(caracter)) {
                    encriptado = Character.toUpperCase(encriptado);
                }
                mensajeEncriptado.append(encriptado);
            } else if (Character.isDigit(caracter)) {
                // Encriptar números
                char encriptado = (char) (((caracter - '0' + 3) % 10) + '0');
                mensajeEncriptado.append(encriptado);
            } else {
                // Conservar otros caracteres
                mensajeEncriptado.append(caracter);
            }
        }

        return mensajeEncriptado.toString();
    }

    public static String desencriptar(String mensajeEncriptado) {
        StringBuilder mensajeDesencriptado = new StringBuilder();

        for (int i = 0; i < mensajeEncriptado.length(); i++) {
            char caracter = mensajeEncriptado.charAt(i);

            if (Character.isLetter(caracter)) {
                // Desencriptar letras
                char desencriptado = (char) (((caracter - 'a' - 3 + 26) % 26) + 'a');
                if (Character.isUpperCase(caracter)) {
                    desencriptado = Character.toUpperCase(desencriptado);
                }
                mensajeDesencriptado.append(desencriptado);
            } else if (Character.isDigit(caracter)) {
                // Desencriptar números
                char desencriptado = (char) (((caracter - '0' - 3 + 10) % 10) + '0');
                mensajeDesencriptado.append(desencriptado);
            } else {
                // Conservar otros caracteres
                mensajeDesencriptado.append(caracter);
            }
        }

        return mensajeDesencriptado.toString();
    }
}
