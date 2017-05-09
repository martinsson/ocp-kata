package it.xpug.ocp.checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

public class DiscountDecorator implements PriceCalculator {

    private List<String> boughtItems = new ArrayList<>();
    private PriceCalculator priceCalculator;
    private Map<String, Discount> unitDiscounts;
    private int discount = 0;

    public DiscountDecorator(PriceCalculator priceCalculator, Map<String, Discount> unitDiscounts) {
        this.priceCalculator = priceCalculator;
        this.unitDiscounts = unitDiscounts;
    }

    @Override
    public int total() {
        return priceCalculator.total() - discount;
    }

    private Integer registerForDiscount(String item) {
        Discount noDiscount = new NoDiscount();
        Discount discounter = unitDiscounts.getOrDefault(item, noDiscount);
        return discounter.registerItem();
    }


    @Override
    public void add(String code) {
        discount+= registerForDiscount(code);
        boughtItems.add(code);
        priceCalculator.add(code);
    }

}
