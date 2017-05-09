package it.xpug.ocp.checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class PriceDecorator implements PriceCalculator {

    protected PriceCalculator priceCalculator;
    private List<String> boughtItems = new ArrayList<>();

    public PriceDecorator(PriceCalculator priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    protected int delegateTotal() {
        return priceCalculator.total();
    }

    protected void delegateAddToCheckout(String code) {
        boughtItems.add(code);
        priceCalculator.add(code);
    }
}
