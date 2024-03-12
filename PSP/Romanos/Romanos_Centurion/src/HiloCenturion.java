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

    public HiloCenturion(int numero){
        puertoServidor = 2000 + numero;
        try {
            skServidor = new ServerSocket(puertoServidor);
            System.out.println("Escucho en el puerto: " + puertoServidor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public HiloCenturion(int puerto,int numero, String accion, int parametro){

        this.parametro = parametro;
        this.puertoServidor = puerto;
        this.numero = numero;
        this.accion = accion;
        tipoTarea = "LOGISTICA";

    }

    public HiloCenturion(int puerto,int numero, String accion, String destinatario, String cuerpo){
        this.destinatario = destinatario;
        this.cuerpo = cuerpo;
        this.puertoServidor = puerto;
        this.numero = numero;
        this.accion = accion;
        tipoTarea = "EXPLORADOR";

    }

    public HiloCenturion(int puerto,int numero, String accion, String queVigilar , int tiempo){

        this.queVigilar = queVigilar;
        this.tiempo = tiempo;
        this.puertoServidor = puerto;
        this.numero = numero;
        this.accion = accion;
        tipoTarea = "SOLDADO";

    }
    @Override
    public void run(){
        while(true){
            try{
                sleep(999999);
            }catch (Exception ex){
                try {
                    conectar();
                    darOrden();
                    out.close();
                    in.close();
                    centurion.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void conectar() throws IOException {

                centurion = skServidor.accept();

                InputStream is = centurion.getInputStream();
                in = new DataInputStream(is);
                String tipoLegionario = in.readUTF();

                OutputStream aux = centurion.getOutputStream();
                out = new DataOutputStream(aux);

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

    public ServerSocket getSkServidor() {
        return skServidor;
    }

    public void setSkServidor(ServerSocket skServidor) {
        this.skServidor = skServidor;
    }

    public Socket getCenturion() {
        return centurion;
    }

    public void setCenturion(Socket centurion) {
        this.centurion = centurion;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPuertoServidor() {
        return puertoServidor;
    }

    public void setPuertoServidor(int puertoServidor) {
        this.puertoServidor = puertoServidor;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public int getParametro() {
        return parametro;
    }

    public void setParametro(int parametro) {
        this.parametro = parametro;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getQueVigilar() {
        return queVigilar;
    }

    public void setQueVigilar(String queVigilar) {
        this.queVigilar = queVigilar;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}
