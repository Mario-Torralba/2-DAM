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
                System.out.println("El CESAR necesita cerveza, introduce los litros: ");
                int litros = sc.nextInt();
                out.writeUTF("CERVEZA");
                out.writeInt(litros);
                break;
            case "PRISIONEROS":
                System.out.println("El CESAR necesita interrogar prisioneros, introduce la cantidad: ");
                int prisioneros = sc.nextInt();
                out.writeUTF("PRISIONEROS");
                out.writeInt(prisioneros);
                break;
            case "PAPEL":
                int metros = random.nextInt(200)+1;
                System.out.println("El CESAR necesita " + metros + " metros de papel de pergamino");
                out.writeUTF("PAPEL");
                out.writeInt(metros);
                break;
            case "MENSAJE":
                System.out.println("El CESAR quiere enviar un mensaje, introduce el destinatario: ");
                String destinatario = sc.next();
                System.out.println("Ahora introduce el mensaje: ");
                String cuerpo = sc.next();
                out.writeUTF("MENSAJE");
                out.writeUTF(destinatario);
                out.writeUTF(cuerpo);
                break;
            case "VIGILANCIA":
                System.out.println("El CESAR quiere hacer vigilancia, introduce de que: ");
                String queVigilar = sc.next();
                System.out.println("Durante cuanto tiempo: ");
                int tiempo = sc.nextInt();
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

}
