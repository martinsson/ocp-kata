package it.xpug.ocp.checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckoutFactory {

    public static CheckOut checkout() {
        Map<String, Integer> prices = new HashMap<String, Integer>();
        prices.put("A", 50);
        prices.put("B", 30);
        prices.put("C", 20);
        return new CheckOut(new SummingCalculator(prices));

    }
}
