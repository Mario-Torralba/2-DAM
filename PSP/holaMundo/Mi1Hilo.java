import java.util.ArrayList;

public class Mi1Hilo extends Thread{

    private int numero;
    public static ArrayList<Mi1Hilo> listaHilos = new ArrayList<>();

    public static ArrayList<Mi1Hilo> getListaHilos() {
        return listaHilos;
    }
    public Mi1Hilo(int numero){
        this.numero = numero;
        listaHilos.add(numero, this);
    }
    public void run(){
        System.out.println("Hola mundo!! Soy el hilo número " + this.numero);
    }

}
