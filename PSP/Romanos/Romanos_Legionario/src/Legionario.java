import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Legionario extends Thread{

    private int numero;
    static final String HOST = "localhost";
    static int puerto;
    private Socket centurion;

    public DataOutputStream out;
    public DataInputStream in;
    public Scanner sc;
    Random random = new Random();

    private String tipoLegionario;

    public Legionario(int puerto, int numero){

        this.puerto = puerto;
        this.numero = numero;
        sc = new Scanner(System.in);

        if(numero==1){
            tipoLegionario ="EXPLORADOR";
        } else if (numero==2) {
            tipoLegionario ="SOLDADO";
        } else if (numero==3) {
            tipoLegionario ="LOGISTICA";
        }else{
            int eleccion = random.nextInt(3)+1;
            switch (eleccion){
                case 1:
                    tipoLegionario = "EXPLORADOR";
                    break;
                case 2:
                    tipoLegionario = "SOLDADO";
                    break;
                case 3:
                    tipoLegionario = "LOGISTICA";
                    break;
            }
        }
    }
    @Override
    public void run(){
        while(true){
            while(true) {
                try {
                    centurion = new Socket(HOST, puerto);

                    OutputStream oS = centurion.getOutputStream();
                    out = new DataOutputStream(oS);
                    out.writeUTF(tipoLegionario);

                    InputStream aux = centurion.getInputStream();
                    in = new DataInputStream(aux);
                    System.out.println(in.readUTF());
                    break;
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }
            try {

                out.writeInt(numero);

                String accion = in.readUTF();

                switch (accion) {
                    case "CERVEZA":
                        int litros = in.readInt();
                        System.out.println("Legionario " + numero + ": " + "Traigo " + litros + " litros de cerveza");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Tarea terminada");
                        out.writeInt(1);
                    case "PRISIONEROS":
                        int prisioneros = in.readInt();
                        System.out.println("Legionario " + numero + ": " + "Traigo " + prisioneros + " para interrogar");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Tarea terminada");
                        out.writeInt(1);
                    case "PAPEL":
                        int metros = in.readInt();
                        System.out.println("Legionario " + numero + ": " + "Traigo " + metros + " metros de papel");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Tarea terminada");
                        out.writeInt(1);
                    case "MENSAJE":
                        String destinatario = in.readUTF();
                        String cuerpo = in.readUTF();
                        System.out.println("Legionario " + numero + ": " + " Mando un mensaje a " + destinatario);
                        try {
                            Thread.sleep(7000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Tarea terminada");
                        out.writeInt(1);
                    case "VIGILANCIA":
                        String queVigilar = in.readUTF();
                        int tiempo = in.readInt();
                        int multiplicacionTiempo = tiempo*1000;
                        System.out.println("Legionario " + numero + ": " + "Vigilando " + queVigilar + " durante " + tiempo + " segundos");
                        try {
                            Thread.sleep(multiplicacionTiempo);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Tarea terminada");
                        out.writeInt(1);
                }
            }catch (Exception ex) {
            }
        }
    }
}
