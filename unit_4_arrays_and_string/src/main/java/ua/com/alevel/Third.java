package ua.com.alevel;

import java.util.Scanner;

public class Third {

    public static void checking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Метод 3");
        System.out.println("Введите строку в которой будете менять символы:");
        String b = scanner.nextLine();
        System.out.println("Введите номер символа с которого начнется замена");
        int c = scanner.nextInt();
        System.out.println("Введите номер символа на котором закончить замену");
        int d = scanner.nextInt();
        if (b.isBlank()) {
            System.out.println("There are no data");
        }
        else if (b.length() < 2 & b.length() > 0) {
            System.out.println("Вы ввели только один символ");
        }
        else
            reverse(b,c,d);
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        String reversedDest = reverseThirdWord(src, firstIndex, lastIndex);
        int c = firstIndex;
        int d = lastIndex;
        String e = src.substring(c, d);
        String result = src.replace(e, reversedDest);
        System.out.println(result);
        return result;
    }

    public static String reverseThirdWord(String src, int firstIndex, int lastIndex) {
        int c = firstIndex;
        int d = lastIndex;
        String e = src.substring(c, d);
        String j = "";
        for (int i = 0; i < e.length(); i++) {
            j = e.charAt(i) + j;
        }
        return j;
    }
}