package Advance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowseHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String input = scanner.nextLine();

        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        while (!input.equals("Home")){
            if (input.equals("forward") && forwardStack.isEmpty()) {
                System.out.println("no next URLs");
            } else if (input.equals("back") && backStack.size() <= 1) {
                System.out.println("no previous URLs");


            } else if (input.equals("forward")){
                backStack.push(forwardStack.peek());
                System.out.println(forwardStack.pop());
            } else if ( input.equals("back")){
                forwardStack.push(backStack.pop());
                System.out.println(backStack.peek());
            } else {
                forwardStack.clear();
                System.out.println(input);
                backStack.push(input);
            }
            input = scanner.nextLine();

        }
    }
}
