package ua.com.alevel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Jupiter extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
        super.name = "Jupiter";
        System.out.println(name);
        super.weight=new BigDecimal(1876.64328  * Math.pow(10, 24));
        super.radius = new BigDecimal(71.300  * Math.pow(10, 6));

        BigDecimal c = G.multiply(weight.divide(radius.pow(2), 6, RoundingMode.CEILING)).setScale(2, RoundingMode.CEILING);
        return c.toString();    }
}
