package it.xpug.ocp.checkout;

import it.xpug.ocp.checkout.decorators.CrossDiscount;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CrossDiscountTest {
    @Test
    public void discountDoesntApplyIfCombination() throws Exception {

        CrossDiscount crossDiscount = new CrossDiscount("E", "C", 2, 26);
        List<String> shoppingBasket = Arrays.asList("E", "C");
        Assert.assertEquals(0, crossDiscount.discount(shoppingBasket));
    }

    @Test
    public void discountAppliesIfCombination() throws Exception {

        CrossDiscount crossDiscount = new CrossDiscount("E", "C", 2, 26);

        List<String> shoppingBasket = Arrays.asList("E", "C", "C");
        Assert.assertEquals(26, crossDiscount.discount(shoppingBasket));
    }
}
