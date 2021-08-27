package ua.com.alevel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Uranus extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
        super.name = "Uranus";
        System.out.println(name);
        super.weight=new BigDecimal(86.05440   * Math.pow(10, 24));
        super.radius = new BigDecimal(26.500  * Math.pow(10, 6));

        BigDecimal c = G.multiply(weight.divide(radius.pow(2), 6, RoundingMode.CEILING)).setScale(2, RoundingMode.CEILING);
        return c.toString();    }
}
