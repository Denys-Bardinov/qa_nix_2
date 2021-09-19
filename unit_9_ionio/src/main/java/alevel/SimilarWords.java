package alevel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimilarWords {
    public String calculateSimilarWords() {
        NewScan scan = new NewScan();
        String scanSimilarWords = scan.returnScan();
        scanSimilarWords = scanSimilarWords.replaceAll("\\. ", " ");
        String[] arraySimilarWords = scanSimilarWords.split(" ");
        String b = "";
        int counter;
        HashMap<String, Integer> values = new HashMap<>();

        for (int i = 0; i < arraySimilarWords.length; i++) {
            counter = 0;
            for (int j = i; j < arraySimilarWords.length; j++) {
                if (arraySimilarWords[i].equals(arraySimilarWords[j])) {
                    counter++;
                }
            }
            if (!values.containsKey(arraySimilarWords[i]))
                values.put(arraySimilarWords[i], counter);
        }

        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            b = (b + pair.getKey() + " = " + pair.getValue() + "\n");
            it.remove();
        }
        return b;
    }
}