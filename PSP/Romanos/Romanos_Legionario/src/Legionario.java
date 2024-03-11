import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Legionario extends Thread{

    private int numero;
    static final String HOST = "localhost";
    static int puerto;
    private Socket centurion;

    public DataOutputStream out;
    public DataInputStream in;
    public Scanner sc;

    public Legionario(int puerto, int numero){

        this.puerto = puerto;
        this.numero = numero;
        sc = new Scanner(System.in);

    }
    @Override
    public void run(){
        while(true){
            while(true) {
                try {
                    centurion = new Socket(HOST, puerto);
                    OutputStream oS = centurion.getOutputStream();
                    out = new DataOutputStream(oS);
                    out.writeUTF("Hola centurion te saluda Legionario " + numero);
                    InputStream aux = centurion.getInputStream();
                    in = new DataInputStream(aux);
                    System.out.println(in.readUTF());
                    break;
                } catch (Exception ex) {

                }
            }
            try {
                String accion = in.readUTF();
                switch (accion) {
                    case "CERVEZA":
                        int litros = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado traer " + litros + " de cerveza");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    case "PRISIONEROS":
                        int prisioneros = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado traer " + prisioneros + " prisioneros");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    case "PAPEL":
                        int metros = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado traer " + metros + " de papel de pergamino");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    case "MENSAJE":
                        String destinatario = in.readUTF();
                        String cuerpo = in.readUTF();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado llevar un mensaje a " + destinatario);
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    case "VIGILANCIA":
                        String queVigilar = in.readUTF();
                        int tiempo = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado vigilar " + queVigilar + " durante " + tiempo + " segundos");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                }
            }catch (Exception ex) {
            }
        }
    }
}
