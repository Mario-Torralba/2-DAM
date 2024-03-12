import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;


public class Centurion extends Thread{


    private int numero;
    static final String HOST = "localhost";
    static final int PUERTO = 5000;
    private int puertoServidor;
    private Socket centurion;


    public DataOutputStream out;
    public DataInputStream in;
    public Scanner sc;


    public Centurion(int puerto,int numero) throws IOException {

        this.puertoServidor = puerto;
        this.numero = numero;
        sc = new Scanner(System.in);

    }
    @Override
    public void run(){
        while(true){
            while(true) {
                try {
                    centurion = new Socket(HOST, PUERTO);
                    OutputStream oS = centurion.getOutputStream();
                    out = new DataOutputStream(oS);
                    out.writeUTF("Ave CESAR te saluda centurion " + numero);
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
                        HiloCenturion hiloCenturion = new HiloCenturion(puertoServidor, numero, "CERVEZA", litros);
                        hiloCenturion.start();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "PRISIONEROS":
                        int prisioneros = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado traer " + prisioneros + " prisioneros");
                        HiloCenturion hiloCenturion2 = new HiloCenturion(puertoServidor, numero, "PRISIONEROS", prisioneros);
                        hiloCenturion2.start();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "PAPEL":
                        int metros = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado traer " + metros + " de papel de pergamino");
                        HiloCenturion hiloCenturion3 = new HiloCenturion(puertoServidor, numero, "PAPEL", metros);
                        hiloCenturion3.start();

                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "MENSAJE":
                        String destinatario = in.readUTF();
                        String cuerpo = in.readUTF();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado llevar un mensaje a " + destinatario);
                        HiloCenturion hiloCenturion4 = new HiloCenturion(puertoServidor, numero, "MENSAJE", destinatario, cuerpo);
                        hiloCenturion4.start();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "VIGILANCIA":
                        String queVigilar = in.readUTF();
                        int tiempo = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado vigilar " + queVigilar + " durante " + tiempo + " segundos");
                        HiloCenturion hiloCenturion5 = new HiloCenturion(puertoServidor, numero, "VIGILANCIA", queVigilar, tiempo);
                        hiloCenturion5.start();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
            }catch (Exception ex) {
                ex.getMessage();
            }
        }

    }
}
