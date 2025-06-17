import java.util.Random;
import java.util.Scanner;

public class ha{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Random random=new Random();

        System.out.println("random seed geenrator");
        String x=scan.nextLine();
        int zufallszahl=random.nextInt();

        while (true) {

            
            System.out.println(zufallszahl);

            System.out.println("willst du eine neue zahl");
            String y=scan.nextLine();

            if(y.toLowerCase().equals("yes")){
                zufallszahl=random.nextInt();
            }else{
                break;
            }


            
        }

        
    }

}