package it.xpug.ocp.checkout;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DiscountDecoratorTest {

    @Test
    public void givesA20DiscountForThreeAs() throws Exception {
        PriceCalculator zeroPrice = new PriceCalculator() {
            @Override
            public int total() {
                return 0;
            }

            @Override
            public void add(String code) {

            }
        };

        DiscountDecorator discountDecorator = new DiscountDecorator(zeroPrice, new HashMap<String, UnitDiscount>() {{
            put("A", new UnitDiscount(3, 20));
        }});

        discountDecorator.add("A");

        Assert.assertEquals(-20, discountDecorator.total());
    }
}
