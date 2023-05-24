package Advance.FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] text = br.readLine().split("\\s+");





        Predicate<String> isIsStartingUpperCase = w -> Character.isUpperCase(w.charAt(0));
        ArrayDeque<String> queueWords = new ArrayDeque<>();
        
        Arrays.stream(text)
                .filter(w -> Character.isUpperCase(w.charAt(0)))
                .forEach(queueWords::offer);

        System.out.println(queueWords.size());

        while (!queueWords.isEmpty()) {
            
            System.out.println(queueWords.poll());
        }


    }
}
