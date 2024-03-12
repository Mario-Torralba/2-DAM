public class Main {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 6; j++) {
                Legionario legionario = new Legionario(2000 + i, j);
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