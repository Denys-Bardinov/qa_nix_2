package ua.com.alevel;

import java.util.Scanner;

public class Second {


    public static void checking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Метод 2");
        System.out.println("Введите строку в которой будет произведен реверс");
        String b = scanner.nextLine();
        System.out.println("Введите символы в строке которые нужно заменить");
        String c = scanner.nextLine();
        if (b.isBlank()) {
            System.out.println("There are no data");
        }
        else if (b.length() < 2 & b.length() > 0) {
            System.out.println("Вы ввели только один символ");
        }
        else
            reverse(b,c);
    }

    public static String reverse(String src, String dest) {
        String reversedDest = reverseDest(dest);
        String result = src.replace(dest, reversedDest);
        System.out.println(result);
        return result;

    }

    public static String reverseDest(String dest) {
        int stringLength = dest.length();
        String j = "";
        for (int i = 0; i < stringLength; i++) {
            j = dest.charAt(i) + j;
        }
        return j;
    }
}
