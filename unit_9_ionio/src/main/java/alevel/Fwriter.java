package alevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fwriter {
    public void method() {

        SimilarWords similarWords = new SimilarWords();
        String b = similarWords.calculateSimilarWords();
        String SimilarWordsResult = ("Одинаковый слова: " + "\n" + b);

        Sentences sentences = new Sentences();
        int sentnecesCount = sentences.calculateSentences();
        String sentenceCountString = Integer.toString(sentnecesCount);
        String sentnecesCountResult = ("Количество предложений = " + sentenceCountString);

        Polindrome polindrome = new Polindrome();
        int polindromeCount = polindrome.calculatePolindrome();
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
