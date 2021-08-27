package ua.com.alevel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Neptune extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
        super.name = "Neptune";
        System.out.println(name);
        super.weight=new BigDecimal(101.59200   * Math.pow(10, 24));
        super.radius = new BigDecimal(24.750  * Math.pow(10, 6));

        BigDecimal c = G.multiply(weight.divide(radius.pow(2), 6, RoundingMode.CEILING)).setScale(2, RoundingMode.CEILING);
        return c.toString();    }
}
