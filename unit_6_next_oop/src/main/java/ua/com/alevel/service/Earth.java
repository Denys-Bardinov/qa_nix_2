package ua.com.alevel.service;

public class Earth extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
        super.name = "Earth";
        System.out.println(name);
        super.weight = 1;
        super.radius =2;

        return String.valueOf(weight*radius*G);
    }


}
