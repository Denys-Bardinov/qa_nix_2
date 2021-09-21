package alevel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Fwriter {
    public void method() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение содержащее полиндромы и одинаковые слова:");
        String scannerResult = scanner.nextLine();
        System.out.println("Посмотрите результат в output.txt");
        File myFile1 = new File("input.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile1));
            writer.write(scannerResult);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String textInPath = "input.txt";
        String value = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(textInPath))) {
            value = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        SimilarWords similarWords = new SimilarWords();
        String b = similarWords.calculateSimilarWords(value);
        String SimilarWordsResult = ("Одинаковый слова: " + "\n" + b);

        Sentences sentences = new Sentences();
        int sentnecesCount = sentences.calculateSentences(value);
        String sentenceCountString = Integer.toString(sentnecesCount);
        String sentnecesCountResult = ("Количество предложений = " + sentenceCountString);

        Polindrome polindrome = new Polindrome();
        int polindromeCount = polindrome.calculatePolindrome(value);
        String polindromeCountString = Integer.toString(polindromeCount);
        String polindromeCountResult = ("Количество полиндромов = " + polindromeCountString);

        File myFile = new File("output.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            writer.write(polindromeCountResult + "\n" + sentnecesCountResult + "\n" + SimilarWordsResult);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
