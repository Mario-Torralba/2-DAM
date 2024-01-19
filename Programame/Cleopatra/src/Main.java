import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int iteraciones = sc.nextInt();

        for (int i = 0; i < iteraciones; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(c>0 && b<0){

                if(c-b-1 < (a-b)*-1){
                    System.out.println(c);
                }else if(c-b-1 > (a-b)*-1){
                    System.out.println(a);
                }else{
                    System.out.println("EMPATE");
                }

            }
            if(a<0 && b>0){

                if(c-b < ((a-b)*-1)-1){
                    System.out.println(c);
                }else if(c-b > ((a-b)*-1)-1){
                    System.out.println(a);
                }else{
                    System.out.println("EMPATE");
                }

            }
            if(a>0 && b>0 && c>0){
                if(c-b < (a-b)*-1){
                    System.out.println(c);
                }else if(c-b > (a-b)*-1){
                    System.out.println(a);
                }else{
                    System.out.println("EMPATE");
                }
            }
            if(a<0 && b<0 && c<0){
                if(c-b < (a-b)*-1){
                    System.out.println(c);
                }else if(c-b > (a-b)*-1){
                    System.out.println(a);
                }else{
                    System.out.println("EMPATE");
                }
            }



        }
    }
}