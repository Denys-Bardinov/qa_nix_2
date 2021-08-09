package ua.com.alevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class TaskTwo {
    public void run() throws IOException {

        System.out.println("Подсчет количества символов");
        System.out.println("Введите любые символы");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String[] b = a.split("");
        int counter;
        HashMap<String, Integer> values = new HashMap<>();

        for (int i = 0; i < b.length; i++) {
            counter = 0;
            for (int j = i; j < b.length; j++) {
                if (b[i].equals(b[j])) {
                    counter++;
                }
            }
            if (!values.containsKey(b[i]))
                values.put(b[i], counter);
        }
        values.forEach((character, counter1) -> System.out.println(character + " " + counter1));
    }
}

