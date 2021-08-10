package ua.com.alevel;

import java.util.Scanner;

public class First {



    public static void checking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Метод 1");
        System.out.println("Введите строку в которой будет произведен реверс");
        String b = scanner.nextLine();
        if (b.isBlank()) {
            System.out.println("There are no data");
        }
        else if (b.length() < 2 & b.length() > 0) {
            System.out.println("Вы ввели только один символ");
        }
        else
            System.out.println("Результат реверса");
        reverse(b);
    }

    public static String reverse(String src) {
        int stringLength = src.length();
        String result = "";
        for (int i = 0; i < stringLength; i++) {
            result = src.charAt(i) + result;
        }
        System.out.println(result);
        return result;
    }

}