package Advance.StacksAndQueues.Exercise;

import java.sql.Array;
import java.util.*;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String text = "";
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] commandArr = scanner.nextLine().split(" ");
            if (commandArr[0].equals("1")) {
                stack.push(text);
                text += commandArr[1];
            } else if (commandArr[0].equals("2")) {
                stack.push(text);
                int count = Integer.parseInt(commandArr[1]);
                List<Character> characterList = new ArrayList<>();
                for (int j = 0; j < text.length(); j++) {
                    characterList.add(text.charAt(j));
                }

                for (int j = 0; j < count; j++) {
                    characterList.remove(characterList.size() - 1);
                }

                if (characterList.isEmpty()) {
                    text = "";
                } else {
                    text = "";
                    for (int j = 0; j < characterList.size(); j++) {
                        text += characterList.get(j);
                    }
                }
            } else if (commandArr[0].equals("3")) {
                int index = Integer.parseInt(commandArr[1]);
                for (int j = 0; j <= index - 1; j++) {
                    if (j == index - 1) {
                        System.out.println(text.charAt(j));
                    }
                }
            } else {
                text = stack.pop();
            }
        }
    }
}
