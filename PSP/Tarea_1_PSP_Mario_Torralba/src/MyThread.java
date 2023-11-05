public class MyThread implements Runnable{

    private String letra;

    public MyThread(String letra){
        this.letra = letra;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hola Mundo, soy el hilo " + letra);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
