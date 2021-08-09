package ua.com.alevel;

public class Third {

    public static String reverse(String src, int firstIndex, int lastIndex) {
        String reversedDest = reverseThirdWord(src, firstIndex, lastIndex);
        int c = firstIndex;
        int d = lastIndex;
        String e = src.substring(c, d);
        String result = src.replace(e, reversedDest);
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