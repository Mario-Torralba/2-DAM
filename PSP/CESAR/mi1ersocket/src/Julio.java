import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Julio {
    static final int PUERTO = 5000;

    public DataInputStream in;
    public DataOutputStream out;

    ServerSocket skServidor;

    public Julio(){
        try {
            skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho en el puerto: " + PUERTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void conectar() throws IOException {
        Socket mi_cliente = skServidor.accept();

        InputStream is = mi_cliente.getInputStream();
        in = new DataInputStream(is);
        System.out.println(in.readUTF());

        OutputStream aux = mi_cliente.getOutputStream();
        out = new DataOutputStream(aux);
        out.writeUTF("Hola Cliente, soy el servidor!!");
    }

}
