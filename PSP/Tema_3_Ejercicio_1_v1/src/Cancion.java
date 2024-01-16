import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Cancion {

    protected String titulo;
    protected static int estrofaActual = 0;
    protected static ArrayList<String> cancion = new ArrayList<>();

    public Cancion(String titulo, String cancion){

        this.titulo = titulo;
        char[] cancionChar = cancion.toCharArray();

        String verso = "";
        int palabras = 0;
        for (int i = 0; i < cancionChar.length; i++) {

            if(cancionChar[i]==' '){
                palabras++;
            }

            verso += cancionChar[i];
            if(cancionChar[i]=='.'){
                this.cancion.add(verso);
                verso = "";
                palabras = 0;
            }
            if(palabras == 9){
                this.cancion.add(verso);
                verso = "";
                palabras = 0;
            }

        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public static ArrayList<String> getCancion() {
        return cancion;
    }

    public static void setCancion(ArrayList<String> cancion) {
        cancion = cancion;
    }
    public void imprimirCancion(){
        int contador = 0;
        for (String element: cancion) {
            contador++;
            System.out.println(element);
        }
        int cantidadDeVersos = contador;
        System.out.println(contador);
    }


    public static int getEstrofaActual() {
        return estrofaActual;
    }

    public static void setEstrofaActual(int estrofaActual) {
        Cancion.estrofaActual = estrofaActual;
    }
}
