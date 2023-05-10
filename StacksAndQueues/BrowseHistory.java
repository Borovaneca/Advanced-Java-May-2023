package Advance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowseHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque <String> urlStack = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("Home")){

            if (command.equals("back")){
                if (urlStack.size() <= 1){
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }  else {
                    urlStack.pop();
                    System.out.println(urlStack.peek());
                }
            } else {
                urlStack.push(command);
                System.out.println(urlStack.peek());
            }


            command = scanner.nextLine();
        }
    }
}
