package ua.com.alevel.service;

public class Mercury extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
        super.name = "Pluton";
        System.out.println(name);
        super.weight = 1;
        super.radius =2;
        return String.valueOf(weight*radius*G);
    }


}
