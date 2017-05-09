package it.xpug.ocp.checkout.decorators;

import it.xpug.ocp.checkout.PriceCalculator;
import it.xpug.ocp.checkout.unitdiscount.NoDiscount;

import java.util.HashMap;
import java.util.Map;

public class UnitDiscountDecorator extends PriceDecorator {

    private Map<String, Discount> unitDiscounts;
    private int discount = 0;

    public UnitDiscountDecorator(PriceCalculator priceCalculator, HashMap<String, Discount> unitDiscounts) {
        super(priceCalculator);
        this.unitDiscounts = unitDiscounts;
    }

    @Override
    protected int decoratorTotal() {
        return - discount;
    }

    private Integer registerForDiscount(String item) {
        Discount noDiscount = new NoDiscount();
        Discount discounter = unitDiscounts.getOrDefault(item, noDiscount);
        return discounter.registerItem();
    }

    @Override
    protected void registerItem(String code) {
        discount+= registerForDiscount(code);
    }

}
