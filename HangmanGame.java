import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the secret word:");
        char[] word = scanner.nextLine().toCharArray();

        ArrayList<Character> arr = new ArrayList<>();
        int fehlversuche = 0;
        boolean richtig = false;

        while (fehlversuche < 10) {
            System.out.println("gebe dein buchstaben ein");
            char w = scanner.nextLine().charAt(0);

            richtig = false;

            for (char e : word) {
                if (e == w) {
                    arr.add(w);
                    System.out.println("du hast den buchstaben " + e + " richtig erraten");
                    richtig = true;
                }
            }

            if (!richtig) {
                System.out.println("du hast leider falsch geraten");
                fehlversuche++;
            }

            System.out.println("deine bisherigen buchstaben sind " + arr);

            Collections.sort(arr);
            Arrays.sort(word);

            char[] arr2 = new char[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                arr2[i] = arr.get(i);
            }

            if (Arrays.equals(arr2, word)) {
                System.out.println("glückwunsch due hat alle rchtig erraten");
            }
        }
        System.out.println("du hats zu viele versuche gebrauchtxcgfc");
        scanner.close();
        ArrayList<String> arr4=new ArrayList<String>();
        String[]arr5=new String[10];

        



    }

  
}
