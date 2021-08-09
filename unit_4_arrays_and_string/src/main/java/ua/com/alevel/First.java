package ua.com.alevel;

import java.util.Scanner;

public class First {

    public String reverse(String src) {
        int stringLength = src.length();
        String result = "";
        for (int i = 0; i < stringLength; i++) {
            result = src.charAt(i) + result;
        }
        return result;
    }
}