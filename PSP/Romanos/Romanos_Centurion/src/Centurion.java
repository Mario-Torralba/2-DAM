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
    private HiloCenturion hiloCenturion;
    private Socket centurion;


    public DataOutputStream out;
    public DataInputStream in;
    public Scanner sc;


    public Centurion(int puerto,int numero) throws IOException {

        this.puertoServidor = puerto;
        this.numero = numero;
        sc = new Scanner(System.in);
        this.hiloCenturion = new HiloCenturion(numero);
        hiloCenturion.start();
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
                        hiloCenturion.setAccion("CERVEZA");
                        hiloCenturion.setParametro(litros);
                        hiloCenturion.interrupt();

                        break;
                    case "PRISIONEROS":
                        int prisioneros = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado traer " + prisioneros + " prisioneros");
                        hiloCenturion.setAccion("PRISIONEROS");
                        hiloCenturion.setParametro(prisioneros);
                        hiloCenturion.interrupt();

                        break;
                    case "PAPEL":
                        int metros = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado traer " + metros + " de papel de pergamino");
                        hiloCenturion.setAccion("PAPEL");
                        hiloCenturion.setParametro(metros);
                        hiloCenturion.interrupt();

                        break;
                    case "MENSAJE":
                        String destinatario = in.readUTF();
                        String cuerpo = in.readUTF();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado llevar un mensaje a " + destinatario);
                        hiloCenturion.setAccion("MENSAJE");
                        hiloCenturion.setDestinatario(destinatario);
                        hiloCenturion.setCuerpo(cuerpo);
                        hiloCenturion.interrupt();

                        break;
                    case "VIGILANCIA":
                        String queVigilar = in.readUTF();
                        int tiempo = in.readInt();
                        System.out.println("Centurion " + numero + ": " + "El CESAR me ha encomendado vigilar " + queVigilar + " durante " + tiempo + " segundos");
                        hiloCenturion.setAccion("VIGILANCIA");
                        hiloCenturion.setQueVigilar(queVigilar);
                        hiloCenturion.setTiempo(tiempo);
                        hiloCenturion.interrupt();

                        break;
                }
            }catch (Exception ex) {
                ex.getMessage();
            }
        }

    }
}
