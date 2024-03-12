public class Main {
    public static void main(String[] args) {
        int contador = 0;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 6; j++) {
                contador ++;
                Legionario legionario = new Legionario(2000 + i, contador);
                legionario.start();
            }
        }
        try {
            Thread.sleep(999999);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}