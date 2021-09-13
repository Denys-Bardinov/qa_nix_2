package ua.com.alevel;

public class Main {
    public static void main(String[] args) {

        MathSet numberMathSet = new MathSet(5,6);

        for (int i =0; i < numberMathSet.numbers.length; i++) {
            if (numberMathSet.numbers[i] != 0) {
            System.out.println(numberMathSet.numbers[i]);
            }
        }






    }
}

