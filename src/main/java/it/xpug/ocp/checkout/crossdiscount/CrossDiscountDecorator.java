package it.xpug.ocp.checkout.crossdiscount;

import it.xpug.ocp.checkout.PriceCalculator;
import it.xpug.ocp.checkout.PriceDecorator;

import java.util.List;

public class CrossDiscountDecorator extends PriceDecorator {

    private final List<CrossDiscount> crossDiscounts;

    public CrossDiscountDecorator(PriceCalculator discountDecorator, List<CrossDiscount> crossDiscounts) {
        super(discountDecorator);
        this.crossDiscounts = crossDiscounts;
    }

    @Override
    protected int decoratorTotal() {
        return - crossDiscounts.stream()
                .mapToInt(discounter -> discounter.discount(this.boughtItems))
                .sum();
    }

    @Override
    protected void registerItem(String code) {

    }
}
