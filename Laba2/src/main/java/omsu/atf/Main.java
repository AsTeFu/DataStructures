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

        System.out.println("y1, y2 ... yn, y1 ... yn: " + LinkedList.merge(linkedList, linkedList));
        System.out.println("y1, y2 ... yn, yn ... y1: " + LinkedList.merge(linkedList, linkedList.getReverse()));
        System.out.println("yn, yn-1 ... y1, y1 ... yn: " + LinkedList.merge(linkedList.getReverse(), linkedList));
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
