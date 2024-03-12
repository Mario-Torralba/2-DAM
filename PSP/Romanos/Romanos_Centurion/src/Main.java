import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Centurion centurion1 = new Centurion(2001,1);
        Centurion centurion2 = new Centurion(2002,2);
        Centurion centurion3 = new Centurion(2003,3);
        Centurion centurion4 = new Centurion(2004,4);



        try{
            centurion1.start();
            centurion2.start();
            centurion3.start();
            centurion4.start();
        }catch(Exception ex){
        }
    }
}
