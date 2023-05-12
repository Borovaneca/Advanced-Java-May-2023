package Advance.StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> leftSideStack = new ArrayDeque<>();

        if (input.length() % 2 != 0) {
            System.out.println("NO");
        } else {

            boolean balanced = true;
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                    leftSideStack.push(currentChar);
                } else {
                    if (leftSideStack.isEmpty()){
                        balanced = false;
                        break;
                    }
                    char openingChar = leftSideStack.pop();

                    if (currentChar == ')' && openingChar != '('){
                        balanced = false;
                        break;
                    } else if (currentChar == '}' && openingChar != '{'){
                        balanced = false;
                        break;
                    } else if (currentChar == ']' && openingChar != '['){
                        balanced = false;
                        break;
                    }
                }
            }
            if (balanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
