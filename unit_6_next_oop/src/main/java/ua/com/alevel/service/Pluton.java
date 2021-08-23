package ua.com.alevel.service;

public class Pluton implements Planet{
    private String name = "pluton";
    private double weight = 1;
    private double radius = 2;
    private static final double G = 6;

    @Override
    public String calculateAccelerationOfGravity() {
        return String.valueOf(weight*radius*G);
    }
}
