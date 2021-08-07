package ua.com.alevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.*;

public class TaskThree {
    public void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Расписание окончания уроков");
        System.out.println("Введите номер урока (от 1 до 10):");
        String a = reader.readLine();
        if (a.equals("")) {
            System.out.println("Вы ничего не ввели");
        } else if (a.matches("[1-9]{1,2}")) {
            int b = Integer.parseInt(a);
            if (b >= 1 & b < 11) {
                int c = b * 45 + (b / 2) * 5 + ((b + 1) / 2 - 1) * 15;
                System.out.println((c / 60) + 9 + ":" + (c % 60));
            } else {
                System.out.println("ведите число меньше 11");
            }
        } else {
            System.out.println("Необходимо ввести номер урока от 1 до 10");
        }
    }
}

