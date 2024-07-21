package Advance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        String input;
        while (!(input = scanner.nextLine()).equals("print")) {
            if (!input.equals("cancel")) {
                queue.offer(input);
                continue;
            }
            if (queue.isEmpty()) {
                System.out.println("Printer is on standby");
                continue;
            }
            System.out.println("Canceled " + queue.poll());
        }
        System.out.println(String.join("\n", queue));
    }
}
