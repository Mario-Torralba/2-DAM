import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Centurion extends Thread{
    private int numero;
    static final String HOST = "localhost";
    static final int PUERTO = 5000;

    public DataOutputStream out;
    public DataInputStream in;
    public Scanner sc;
    public Centurion(int numero){
        this.numero = numero;
    }

    @Override
    public void run(){

        Boolean continuar;

        do { // Cuando un cliente se conecta se queda con él hasta que el cliente sale
            try {
                continuar = execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while(continuar);

        System.out.println("Cliente desconectado");

        try {
            out.close();
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean execute() throws IOException {

        String action = in.readUTF();

        switch(action){
            case "SUMA":
                suma();
                break;
            case "RAIZ_CUADRADA":
                raizCuadrada();
                break;
            case "SERIE":
                serie();
                break;
            case "SALIR":
                return false;
        }

        return true;

    }

    public void suma() throws IOException {
        Double a = in.readDouble();
        Double b = in.readDouble();
        Double response = a + b;

        String responseTXT = "La suma de " + a + " y " + b +" es " + response;
        System.out.println(responseTXT);
        out.writeUTF(responseTXT);
    }

    public void raizCuadrada() throws IOException{
        Double a = in.readDouble();
        Double response = Math.sqrt(a);

        String responseTXT = "La raíz cuadrada de " + a + " es " + response;
        System.out.println(responseTXT);
        out.writeUTF(responseTXT);
    }

    private void serie() throws IOException {
        Integer cantidad = in.readInt();

        for (int i = 0; i < cantidad - 2; i++) {
            in.readInt();
        }

        Integer penultimo = in.readInt();
        Integer ultimo = in.readInt();

        Integer response = ultimo + (ultimo - penultimo);

        String responseTXT = "El siguiente número de la serie es " + response;
        System.out.println(responseTXT);
        out.writeUTF(responseTXT);
    }


}
