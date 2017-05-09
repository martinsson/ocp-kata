package it.xpug.ocp.checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckoutFactory {

    public static CheckOut checkout() {
        Map<String, Integer> prices = new HashMap<String, Integer>();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);

        SummingCalculator priceCalculator = new SummingCalculator(prices);
        Map<String, Discount> unitDiscounts = new HashMap<String,Discount>() {{
            put("A", new UnitDiscount(3, 20));
            put("B", new UnitDiscount(2, 15));
        }};
        DiscountDecorator discountDecorator = new DiscountDecorator(priceCalculator, unitDiscounts);
        return new CheckOut(discountDecorator);

    }
}
