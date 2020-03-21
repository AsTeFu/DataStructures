package omsu.atf;

import java.util.Scanner;

public class Main {

    private static final String message = "Enter number: ";
    private static final String messageError = "Enter again: ";
    private static final String stop = "stop";

    public static void main(String[] args) {
        LinkedList<Integer> linkedList;
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Fill the list");
            linkedList = fillList(scan);
        }

        System.out.println("Result: " + linkedList.toString());

        boolean isNonDecreasing = linkedList.isNonDecreasing(Integer::compareTo);
        System.out.println("Is non-decreasing: " + isNonDecreasing);
        if (!isNonDecreasing) {
            LinkedList<Integer> reverse = linkedList.getReverse();
            System.out.println("Reverse list: " + reverse.toString());
        }
    }

    private static LinkedList<Integer> fillList(final Scanner scan) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        while (true) {
            System.out.print(message);
            while (!scan.hasNextInt()) {
                if (scan.next().equalsIgnoreCase(stop)) return linkedList;
                System.out.print(messageError);
            }
            linkedList.pushTail(scan.nextInt());
        }
    }

}
