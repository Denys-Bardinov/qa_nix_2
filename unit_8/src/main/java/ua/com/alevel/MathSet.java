package ua.com.alevel;

public class MathSet {

    private int capacity = 2;
    public int[] numbers = new int[capacity];
    private int internalCounter = 0;

    public MathSet(int n) {
        if (internalCounter >= capacity) {
            capacity += capacity + 1;
            int[] newStorage = new int[capacity];
            for (int i = 0; i < numbers.length; i++) {
                newStorage[i] = numbers[i];
            }
            numbers = newStorage;
        }
        numbers[internalCounter] = n;
        internalCounter++;
    }

    public MathSet(int... n) {
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }


    }

}








