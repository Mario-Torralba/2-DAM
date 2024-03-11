import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloCenturion extends Thread {

    ServerSocket skServidor;
    Socket centurion;
    public DataInputStream in;
    public DataOutputStream out;
    private int numero;
    private int puertoServidor;
    private String accion;

    private int litros;
    private int prisioneros;
    private int metros;

    private String destinatario;
    private String cuerpo;

    private String queVigilar;
    private int tiempo;

    public HiloCenturion(int puerto,int numero, String accion, int parametro){

        this.puertoServidor = puerto;
        this.numero = numero;
        this.accion = accion;

        try {
            skServidor = new ServerSocket(puertoServidor);
            System.out.println("Escucho en el puerto: " + puertoServidor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HiloCenturion(int puerto,int numero, String accion, String destinatario, String cuerpo){
        this.destinatario = destinatario;
        this.cuerpo = cuerpo;
        this.puertoServidor = puerto;
        this.numero = numero;
        this.accion = accion;

        try {
            skServidor = new ServerSocket(puertoServidor);
            System.out.println("Escucho en el puerto: " + puertoServidor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HiloCenturion(int puerto,int numero, String accion, String queVigilar , int tiempo){

        this.queVigilar = queVigilar;
        this.tiempo = tiempo;
        this.puertoServidor = puerto;
        this.numero = numero;
        this.accion = accion;

        try {
            skServidor = new ServerSocket(puertoServidor);
            System.out.println("Escucho en el puerto: " + puertoServidor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run(){
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

    public void conectar() throws IOException {
        centurion = skServidor.accept();

        InputStream is = centurion.getInputStream();
        in = new DataInputStream(is);
        System.out.println(in.readUTF());

        OutputStream aux = centurion.getOutputStream();
        out = new DataOutputStream(aux);
        out.writeUTF("Hola Legionario, aqui CENTURION " + numero);
    }

    public void darOrden() throws IOException {

        switch (accion){
            case "CERVEZA":
            case "PRISIONEROS":
            case "PAPEL":
            case "MENSAJE":
            case "VIGILANCIA":
        }

    }

}
