package ua.com.alevel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Venus extends BasePlanet implements Planet{

    @Override
    public String calculateAccelerationOfGravity() {
      super.name = "Venus";
     System.out.println(name);
        super.weight=new BigDecimal(5.97);
        super.radius = new BigDecimal(2.0);

        return (weight.divide((radius.multiply(radius))).multiply(G)).setScale(2, RoundingMode.CEILING).toString();
    }


}
