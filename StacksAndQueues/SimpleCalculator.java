package Advance.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String operator = null;
        for (String item : inputArr){

            if (item.equals("+") || item.equals("-")){
                operator = item;
            } else if (stack.isEmpty()){
                stack.push(Integer.parseInt(item));
            } else {
                int currentNumber = Integer.parseInt(item);
                int lasNumber = stack.peek();
                stack.pop();
                if (operator.equals("+")){
                    stack.push(currentNumber + lasNumber);
                } else {
                    stack.push(lasNumber - currentNumber);
                }
            }
        }
        System.out.println(stack.peek());
    }
}
