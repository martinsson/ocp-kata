package it.xpug.ocp.checkout.unitdiscount;

import it.xpug.ocp.checkout.PriceCalculator;
import it.xpug.ocp.checkout.PriceDecorator;

import java.util.Map;

public class UnitDiscountDecorator extends PriceDecorator {

    private Map<String, Discount> unitDiscounts;
    private int discount = 0;

    public UnitDiscountDecorator(PriceCalculator priceCalculator, Map<String, Discount> unitDiscounts) {
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
