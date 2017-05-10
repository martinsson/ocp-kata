package it.xpug.ocp.checkout.main;

import it.xpug.ocp.checkout.CrossDiscount;
import it.xpug.ocp.checkout.decorators.DiscountDecorator;
import it.xpug.ocp.checkout.decorators.PriceDecorator;

import java.util.List;

class CrossDiscountDecorator extends PriceDecorator {

    private final List<CrossDiscount> crossDiscounts;

    public CrossDiscountDecorator(DiscountDecorator discountDecorator, List<CrossDiscount> crossDiscounts) {
        super(discountDecorator);
        this.crossDiscounts = crossDiscounts;
    }

    @Override
    protected int decoratorTotal() {
        return - crossDiscounts.stream().mapToInt(discounter -> discounter.discount(this.boughtItems)).sum();
    }

    @Override
    protected void registerItem(String code) {

    }
}
