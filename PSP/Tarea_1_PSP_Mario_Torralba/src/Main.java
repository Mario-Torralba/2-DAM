public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo1 = new Thread(new MyThread("A"));
        Thread hilo2 = new Thread(new MyThread("B"));
        Thread hilo3 = new Thread(new MyThread("C"));

        hilo1.start();
        hilo1.
        hilo2.start();
        hilo3.start();


    }
}