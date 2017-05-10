package it.xpug.ocp.checkout.main;

import it.xpug.ocp.checkout.CheckOut;
import it.xpug.ocp.checkout.CrossDiscount;
import it.xpug.ocp.checkout.decorators.Discount;
import it.xpug.ocp.checkout.decorators.DiscountDecorator;
import it.xpug.ocp.checkout.decorators.PriceDecorator;
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
        DiscountDecorator discountDecorator = new DiscountDecorator(priceCalculator, unitDiscounts);
        CrossDiscount crossDiscount = new CrossDiscount("E", "C", 2, 36);
        List<CrossDiscount> crossDiscounts = Arrays.asList(crossDiscount);
        PriceDecorator crossDiscountDecorator = new PriceDecorator(discountDecorator) {

            @Override
            protected int decoratorTotal() {

                return - crossDiscounts.stream().mapToInt(discounter -> discounter.discount(this.boughtItems)).sum();
//                return -crossDiscount.discount(this.boughtItems);
            }

            @Override
            protected void registerItem(String code) {

            }
        };
        return new CheckOut(crossDiscountDecorator);

    }
}
