package ua.com.alevel;


    public class Second {
        public static String reverse(String src, String dest) {
            String reversedDest = reverseDest(dest);
            String result = src.replace(dest, reversedDest);
            return result;
        }

        public static String reverseDest (String dest) {
            int stringLength = dest.length();
            String j = "";
            for (int i = 0; i < stringLength; i++) {
                j = dest.charAt(i) + j;
            }
            return j;
        }

    }

