package it.xpug.ocp.checkout;

import org.junit.Assert;
import org.junit.Test;

public class UnitDiscountTest {
    @Test
    public void appliesDiscountWhenMinimumQuanityIsReached() throws Exception {
        UnitDiscount unitDiscount = new UnitDiscount(2, 50);
        Assert.assertEquals(0, unitDiscount.registerItem());
        Assert.assertEquals(50, unitDiscount.registerItem());
        Assert.assertEquals(0, unitDiscount.registerItem());
        Assert.assertEquals(50, unitDiscount.registerItem());
    }


    @Test
    public void appliesDiscountWhenMinimumQuanityIsReached3() throws Exception {
        UnitDiscount unitDiscount = new UnitDiscount(3, 30);
        Assert.assertEquals(0, unitDiscount.registerItem());
        Assert.assertEquals(0, unitDiscount.registerItem());
        Assert.assertEquals(30, unitDiscount.registerItem());
        Assert.assertEquals(0, unitDiscount.registerItem());
        Assert.assertEquals(0, unitDiscount.registerItem());
        Assert.assertEquals(30, unitDiscount.registerItem());
    }
}
