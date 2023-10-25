public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Mi1Hilo hilo = new Mi1Hilo(i);
            hilo.start();
            try {
                hilo.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }

        System.out.println("Adios Mundo");

    }
}