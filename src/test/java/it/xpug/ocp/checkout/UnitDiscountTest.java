package it.xpug.ocp.checkout;

import org.junit.Assert;
import org.junit.Test;

public class UnitDiscountTest {
    @Test
    public void appliesDiscountWhenMinimumQuanityIsReached() throws Exception {
        Discount discount = new UnitDiscount(2, 50);
        Assert.assertEquals(0, discount.registerItem());
        Assert.assertEquals(50, discount.registerItem());
        Assert.assertEquals(0, discount.registerItem());
        Assert.assertEquals(50, discount.registerItem());
    }


    @Test
    public void appliesDiscountWhenMinimumQuanityIsReached3() throws Exception {
        Discount discount = new UnitDiscount(3, 30);
        Assert.assertEquals(0, discount.registerItem());
        Assert.assertEquals(0, discount.registerItem());
        Assert.assertEquals(30, discount.registerItem());
        Assert.assertEquals(0, discount.registerItem());
        Assert.assertEquals(0, discount.registerItem());
        Assert.assertEquals(30, discount.registerItem());
    }
}
