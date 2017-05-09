package it.xpug.ocp.checkout;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DiscountDecoratorTest {
    PriceCalculator fixedPriceOf50 = new PriceCalculator() {
        @Override
        public int total() {
            return 50;
        }

        @Override
        public void add(String code) {

        }
    };

    DiscountDecorator discountDecorator = new DiscountDecorator(fixedPriceOf50, new HashMap<String, Discount>() {{
        put("A", new UnitDiscount(3, 20));
    }});

    @Test
    public void givesA20DiscountForThreeAs() throws Exception {

        discountDecorator.add("A");
        discountDecorator.add("A");
        discountDecorator.add("A");

        Assert.assertEquals(50-20, discountDecorator.total());
    }

    @Test
    public void givesNoDiscountBelowRequiredQuantity() throws Exception {
        discountDecorator.add("A");
        discountDecorator.add("B");
        discountDecorator.add("C");

        Assert.assertEquals(50, discountDecorator.total());

    }
}
