package ua.com.alevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class TaskOne {

    public void run() throws IOException {
        System.out.println("Сумма введенных чисел");
        System.out.println("Введите любую строку содержащюю числа:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        int value = Integer.parseInt(a.replaceAll("[^0-9]", ""));
        String str = Integer.toString(value);
        char[] array = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int b = Integer.parseInt(String.valueOf(array[i]));
            sum = sum + b;
        }
        System.out.println("Сумма чисел: " + sum);
    }
}
