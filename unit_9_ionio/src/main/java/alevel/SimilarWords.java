package alevel;

import java.util.*;
import java.util.stream.Collectors;

public class SimilarWords{
    public String calculateSimilarWords(String scan) {
        String scanSimilarWords = scan;
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

        List<Map.Entry<String, Integer>> list = new ArrayList<>(values.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue() - e2.getValue();
            }
        }.reversed());
        b = list.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining("\n"));
        return b;
    }
}