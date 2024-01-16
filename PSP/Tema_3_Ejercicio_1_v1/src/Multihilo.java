import java.util.ArrayList;

public class Multihilo extends Thread{

    protected static int idClase = -1;
    protected int idHilo;
    protected static int contadorHilos = 0;
    boolean reset;
    boolean salida = true;

    protected static ArrayList<Multihilo> lstHilos = new ArrayList<>();

    public Multihilo(){
        idClase++;
        this.idHilo = idClase;
        lstHilos.add(this);
    }

    @Override
    public synchronized void run() {

        while(salida){

            try {
                sleep(9999);
            } catch (InterruptedException e) {

                try{
                    Cancion.getCancion().get(Cancion.getEstrofaActual());
                }catch(Exception ex){
                    salida = false;
                }

                System.out.println("Soy el hilo " + idHilo + " -------> " + Cancion.getCancion().get(Cancion.getEstrofaActual()));
                Cancion.setEstrofaActual(Cancion.getEstrofaActual()+1);

                if(this.idHilo == lstHilos.size()-1){
                    reset = true;
                }

                if(reset){
                    lstHilos.get(0).interrupt();
                }else{
                    lstHilos.get(this.idHilo+1).interrupt();
                }

            }

        }


    }

    public static int getIdClase() {
        return idClase;
    }

    public static void setIdClase(int idClase) {
        Multihilo.idClase = idClase;
    }

    public int getIdHilo() {
        return idHilo;
    }

    public void setIdHilo(int idHilo) {
        this.idHilo = idHilo;
    }

    public static ArrayList<Multihilo> getLstHilos() {
        return lstHilos;
    }

    public static void setLstHilos(ArrayList<Multihilo> lstHilos) {
        Multihilo.lstHilos = lstHilos;
    }
    public static int getContadorHilos() {
        return contadorHilos;
    }

    public static void setContadorHilos(int contadorHilos) {
        Multihilo.contadorHilos = contadorHilos;
    }
}
