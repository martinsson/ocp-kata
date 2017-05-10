package it.xpug.ocp.checkout.main;

import it.xpug.ocp.checkout.CheckOut;
import it.xpug.ocp.checkout.PriceCalculator;
import it.xpug.ocp.checkout.PriceDecorator;
import it.xpug.ocp.checkout.crossdiscount.*;
import it.xpug.ocp.checkout.unitdiscount.Discount;
import it.xpug.ocp.checkout.unitdiscount.UnitDiscountDecorator;
import it.xpug.ocp.checkout.pricecalculators.SummingCalculator;
import it.xpug.ocp.checkout.unitdiscount.UnitDiscount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutFactory {

    public static CheckOut checkout() {
        Map<String, Integer> prices = new HashMap<String, Integer>();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        prices.put("E", 55);

        SummingCalculator priceCalculator = new SummingCalculator(prices);
        Map<String, Discount> unitDiscounts = new HashMap<String,Discount>() {{
            put("A", new UnitDiscount(3, 20));
            put("B", new UnitDiscount(2, 15));
        }};
        PriceCalculator discountDecorator = new UnitDiscountDecorator(priceCalculator, unitDiscounts);
        CrossDiscount crossDiscount = new CrossDiscount("E", "C", 2, 36);
        List<CrossDiscount> crossDiscounts = Arrays.asList(crossDiscount);
        PriceDecorator crossDiscountDecorator = new CrossDiscountDecorator(discountDecorator, crossDiscounts);
        return new CheckOut(crossDiscountDecorator);

    }

}
