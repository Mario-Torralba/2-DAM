import java.util.concurrent.Semaphore;

public class Main {

    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

        MyThread hilo1 = new MyThread("A", semaphoreA, semaphoreB);
        MyThread hilo2 = new MyThread("B", semaphoreB, semaphoreC);
        MyThread hilo3 = new MyThread("C", semaphoreC, semaphoreA);

        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}