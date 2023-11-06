import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

    private String letra;
    private Semaphore currentSemaphore;
    private Semaphore nextSemaphore;


    public MyThread(String letra, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        this.letra = letra;
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                currentSemaphore.acquire();
                System.out.println("Hola Mundo, soy el hilo " + letra);
                nextSemaphore.release();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

}
