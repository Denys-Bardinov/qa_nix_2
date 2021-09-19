package alevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Fwriter {
    public void method() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение содержащее полиндромы и одинаковые слова:");
        String scannerResult = scanner.nextLine();
        System.out.println("Посмотрите результат в text.txt");


        SimilarWords similarWords = new SimilarWords();
        String b = similarWords.calculateSimilarWords(scannerResult);
        String SimilarWordsResult = ("Одинаковый слова: " + "\n" + b);

        Sentences sentences = new Sentences();
        int sentnecesCount = sentences.calculateSentences(scannerResult);
        String sentenceCountString = Integer.toString(sentnecesCount);
        String sentnecesCountResult = ("Количество предложений = " + sentenceCountString);

        Polindrome polindrome = new Polindrome();
        int polindromeCount = polindrome.calculatePolindrome(scannerResult);
        String polindromeCountString = Integer.toString(polindromeCount);
        String polindromeCountResult = ("Количество полиндромов = " + polindromeCountString);

        File myFile = new File("text.txt");
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
