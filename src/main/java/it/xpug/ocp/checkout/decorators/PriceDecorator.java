package it.xpug.ocp.checkout.decorators;

import it.xpug.ocp.checkout.PriceCalculator;

import java.util.ArrayList;
import java.util.List;

public abstract class PriceDecorator implements PriceCalculator {

    protected PriceCalculator priceCalculator;
    protected List<String> boughtItems = new ArrayList<>();

    public PriceDecorator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    @Override
    public int total() {
        return priceCalculator.total() + decoratorTotal();
    }

    protected abstract int decoratorTotal();

    @Override
    public void add(String code) {
        registerItem(code);
        boughtItems.add(code);
        priceCalculator.add(code);
    }

    protected abstract void registerItem(String code);


}
