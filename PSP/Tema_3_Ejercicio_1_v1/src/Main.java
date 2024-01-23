import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Multihilo> listaHilos = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Cuántos hilos quieres que tenga el programa?");
        int iteraciones = sc.nextInt();

        Cancion cancion = new Cancion("LoLolo","I hear strings play " +
                "Every time you look my way " +
                "Don't you know that's what you do " +
                "Feels like ooh " +
                "Make my heart beat " +
                "Double time when you're on me " +
                "Don't you know that's what you do " +
                "What you do, what you do " +
                "Girl, you mute out all the nonsense, all the toxic " +
                "We can talk on any topic and never stop it " +
                "I know you got other options, a lotta prospects " +
                "But they only know the single, I want the box set " +
                "Pushin' buttons with your high heels or your high tops " +
                "Turnin' heads and give 'em all the feels way that you walk " +
                "Could be a sign, alright " +
                "Might be losin' my mind " +
                "'Cause I hear strings play " +
                "Every time you look my way, hey " +
                "Don't you know that's what you do " +
                "Feels like ooh (ah) " +
                "Make my heart beat " +
                "Double time when you're on me (on me) " +
                "Don't you know that's what you do (girl, you know that's what you do- ayy, yeah) " +
                "What you do, what you do " +
                "Girl, you sound just like the theme song, can turn my dreams on " +
                "You the start of a movie, I'm watchin' reruns " +
                "Wanna cut off all my options, put you on top them " +
                "We just stepped outside in public, the cameras poppin' " +
                "Hold on to me right now, I'll protect you " +
                "You can ruin my life, girl, I'll let you " +
                "Feel your heart when it's beating " +
                "You the one, girl, and I'm fiendin' " +
                "I hear symphonies when you speakin', it's true " +
                "'Cause I hear strings play " +
                "Every time you look my way " +
                "Don't you know that's what you do (hey, hey, hey) " +
                "Feels like ooh " +
                "Make my heart beat " +
                "Double time when you're on me " +
                "Don't you know that's what you do (girl, you know that's what you do) " +
                "What you do, what you do " +
                "Mm " +
                "What you do");

        for (int i = 0; i < iteraciones; i++) {

            Multihilo hilo = new Multihilo();
            listaHilos.add(hilo);
            hilo.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        Multihilo.getLstHilos().get(0).interrupt();

        try {
            listaHilos.get(0).join();
        } catch (InterruptedException e) {
        }

        System.out.println("CLAP, CLAP, CLAP");
    }

}