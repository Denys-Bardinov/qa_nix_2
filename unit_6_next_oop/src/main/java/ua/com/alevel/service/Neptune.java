package ua.com.alevel.service;

public class Neptune extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
        super.name = "Neptune";
        System.out.println(name);
        super.weight = 1;
        super.radius =2;
        super.G = 6;
        return String.valueOf(weight*radius*G);
    }


}
