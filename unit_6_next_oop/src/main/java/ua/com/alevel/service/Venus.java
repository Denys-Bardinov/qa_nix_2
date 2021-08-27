package ua.com.alevel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Venus extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
      super.name = "Venus";
     System.out.println(name);
        super.weight=new BigDecimal(4.81068   * Math.pow(10, 24));
        super.radius = new BigDecimal(6.052  * Math.pow(10, 6));

        BigDecimal c = G.multiply(weight.divide(radius.pow(2), 6, RoundingMode.CEILING)).setScale(2, RoundingMode.CEILING);
        return c.toString();    }
}
