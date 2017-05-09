package it.xpug.ocp.checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitDiscountDecorator extends PriceDecorator {

    private Map<String, Discount> unitDiscounts;
    private int discount = 0;

    public UnitDiscountDecorator(PriceCalculator priceCalculator, HashMap<String, Discount> unitDiscounts) {
        super(priceCalculator);
        this.unitDiscounts = unitDiscounts;
    }

    @Override
    public int total() {
        return delegateTotal() - discount;
    }

    private Integer registerForDiscount(String item) {
        Discount noDiscount = new NoDiscount();
        Discount discounter = unitDiscounts.getOrDefault(item, noDiscount);
        return discounter.registerItem();
    }


    @Override
    public void add(String code) {
        discount+= registerForDiscount(code);
        delegateAddToCheckout(code);
    }

}
