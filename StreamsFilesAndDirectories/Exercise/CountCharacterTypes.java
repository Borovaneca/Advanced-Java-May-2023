package Advance.StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class CountCharacterTypes {

    public static void main(String[] args) throws IOException {

        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuationsSet = Set.of('!', '.', ',', '?');
        BufferedReader reader = new BufferedReader(new FileReader("Exercise_StreamsFilesAndDirectories/resources/input.txt"));

        int vowelsCount = 0;
        int othersCount = 0;
        int punctuationCount = 0;

        String line = reader.readLine();
        while (line != null) {

            for (char symbol : line.toCharArray()) {
                boolean isVowel = vowelsSet.contains(symbol);
                boolean isPunctuation = punctuationsSet.contains(symbol);
                if (isVowel) {
                    vowelsCount++;
                } else if (isPunctuation) {
                    punctuationCount++;
                } else if (symbol != ' ') {
                    othersCount++;
                }
            }
            line = reader.readLine();
        }

        reader.close();
        System.out.printf("Vowels: %d\nOther symbols: %d\nPunctuation: %d\n", vowelsCount, othersCount, punctuationCount);
    }
}
