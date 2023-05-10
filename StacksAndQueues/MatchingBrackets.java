package Advance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        ArrayDeque<Integer> expressionStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '('){
                expressionStack.push(i);
            } else if (currentChar == ')'){
                int startIndex = expressionStack.pop();
                int endIndex = i;

                String subExpression = input.substring(startIndex, endIndex + 1);
                System.out.println(subExpression);
            }
        }


    }
}