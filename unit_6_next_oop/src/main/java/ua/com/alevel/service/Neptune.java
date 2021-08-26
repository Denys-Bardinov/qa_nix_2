package ua.com.alevel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Neptune extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
        super.name = "Neptune";
        System.out.println(name);
        super.weight=new BigDecimal(5.97);
        super.radius = new BigDecimal(2.0);

        return (weight.divide((radius.multiply(radius))).multiply(G)).setScale(2, RoundingMode.CEILING).toString();
    }


}
