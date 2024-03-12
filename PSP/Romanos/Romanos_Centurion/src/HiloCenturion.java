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
    private String tipoTarea;

    private int parametro;

    int contador = 0;

    private String destinatario;
    private String cuerpo;

    private String queVigilar;
    private int tiempo;

    public HiloCenturion(int puerto,int numero, String accion, int parametro){

        this.parametro = parametro;
        this.puertoServidor = puerto;
        this.numero = numero;
        this.accion = accion;
        tipoTarea = "LOGISTICA";

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
        tipoTarea = "EXPLORADOR";

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
        tipoTarea = "SOLDADO";

        try {
            skServidor = new ServerSocket(puertoServidor);
            System.out.println("Escucho en el puerto: " + puertoServidor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run(){
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

    public void conectar() throws IOException {
        while(true){
            try{
                centurion = skServidor.accept();

                InputStream is = centurion.getInputStream();
                in = new DataInputStream(is);
                String tipoLegionario = in.readUTF();

                OutputStream aux = centurion.getOutputStream();
                out = new DataOutputStream(aux);

                if(tipoLegionario.equals(tipoTarea)){
                    out.writeUTF("Hola Legionario, aqui CENTURION " + numero);
                    break;
                }
            }catch (Exception ex){
                ex.getMessage();
            }
        }
    }

    public void darOrden() throws IOException {
        int legionario = in.readInt();
        System.out.println("Mi siervo legionario " + legionario + " se ocupará de ello");
        switch (accion){
            case "CERVEZA":
                out.writeUTF("CERVEZA");
                out.writeInt(parametro);
                if(in.readInt()==1){
                    System.out.println("El legionario " + legionario + " ha traido la cerveza");
                }
                break;
            case "PRISIONEROS":
                out.writeUTF("PRISIONEROS");
                out.writeInt(parametro);
                if(in.readInt()==1){
                    System.out.println("El legionario " + legionario + " ha traido a los prisioneros");
                }
                break;
            case "PAPEL":
                out.writeUTF("PAPEL");
                out.writeInt(parametro);
                if(in.readInt()==1){
                    System.out.println("El legionario " + legionario + " ha traido el papel de pergamino");
                }
                break;
            case "MENSAJE":
                out.writeUTF("MENSAJE");
                out.writeUTF(destinatario);
                out.writeUTF(cuerpo);
                if(in.readInt()==1){
                    System.out.println("El legionario " + legionario + " ha enviado el mensaje");
                }
                break;
            case "VIGILANCIA":
                out.writeUTF("VIGILANCIA");
                out.writeUTF(queVigilar);
                out.writeInt(tiempo);
                if(in.readInt()==1){
                    System.out.println("El legionario " + legionario + " ha terminado la vigilancia");
                }
                break;
        }

    }

}
