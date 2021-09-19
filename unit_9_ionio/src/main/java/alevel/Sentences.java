package alevel;

public class Sentences{
    public int calculateSentences(String scan) {
        String sentenScan = scan;
        int sentenceCounter = 0;
        String[] sentncesArray = sentenScan.split("\\.");
        for (int i = 0; i < sentncesArray.length; i++) {
            sentenceCounter++;
        };

        return sentenceCounter;
    }
}
