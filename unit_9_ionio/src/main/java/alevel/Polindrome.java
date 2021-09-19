package alevel;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Polindrome{

    public int calculatePolindrome(String scan) {
        String scanStringInPolindrome = scan;
        scanStringInPolindrome = scanStringInPolindrome.replaceAll("\\. ", " ");
        int polindromeCounter = 0;

        String[] scanStringInPolindromeItemsArrray = scanStringInPolindrome.split(" ");
        for (int i = 0; i < scanStringInPolindromeItemsArrray.length; i++) {
            List<Character> list = new LinkedList<>();
            for (char ch : scanStringInPolindromeItemsArrray[i].toCharArray()) {
                list.add(ch);
            }
            ListIterator<Character> iterator = list.listIterator();
            ListIterator<Character> reverseIterator = list.listIterator(list.size());
            boolean isPalindrome = true;
            while (iterator.hasNext() && reverseIterator.hasPrevious()) {
                if (iterator.next() != reverseIterator.previous()) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                polindromeCounter++;
            }
        }
        return polindromeCounter;
    }
}
