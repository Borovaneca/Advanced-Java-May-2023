package Advance.StacksAndQueues.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split("\\s+");

        StringBuilder output = new StringBuilder();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        String[] operators = new String[] {"+", "-", "*", "/", "(", ")"};

        for (int i = 0; i < input.length; i++) {
            String current = input[i];

            // If the current symbol is an operator
            if(contains(current, operators)){

                if(current.equals("(")){
                    operatorStack.push(current);
                    continue;
                }

                if(current.equals(")")){
                    String element = operatorStack.pop();
                    while (!element.equals("(")){
                        output.append(element + " ");
                        element = operatorStack.pop();
                    }
                    continue;
                }


                int scannedPrecedence = getPrecedence(current);

                if(operatorStack.isEmpty()){
                    operatorStack.push(current);
                    continue;
                }

                if(scannedPrecedence > getPrecedence(operatorStack.peek())){
                    operatorStack.push(current);
                    continue;
                }

                while (!operatorStack.isEmpty() && scannedPrecedence <= getPrecedence(operatorStack.peek())){
                    output.append(operatorStack.pop() + " ");
                }
                operatorStack.push(current);
            }
            else{
                output.append(current + " ");
            }
        }

        while (!operatorStack.isEmpty()){
            output.append(operatorStack.pop() + " ");
        }
        System.out.println(output.toString().trim());
    }

    private static int getPrecedence(String current) {
        switch (current){
            case "+":
                return 2;
            case "-":
                return 2;
            case "*":
                return 3;
            case "/":
                return 3;

        }
        return 0;
    }

    private static boolean contains(String symbol, String[] operators){
        for (int i = 0; i < operators.length; i++) {
            String operator = operators[i];
            if(symbol.equals(operator)){
                return true;
            }
        }
        return false;
    }
}
