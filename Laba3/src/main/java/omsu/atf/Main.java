package omsu.atf;

import java.util.Scanner;

public class Main {

    private static final String message = "Enter word: ";
    private static final String stop = "stop";

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                System.out.print(message);
                String word = scan.nextLine();
                if (word.equalsIgnoreCase(stop)) return;

                PalindromeTester tester = new PalindromeTester(word);
                System.out.println(tester.testPalindrome() + "\n");
            }
        }
    }


}
