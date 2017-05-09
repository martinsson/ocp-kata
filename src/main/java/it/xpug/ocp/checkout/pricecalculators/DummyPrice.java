package it.xpug.ocp.checkout.pricecalculators;

import it.xpug.ocp.checkout.PriceCalculator;

public class DummyPrice implements PriceCalculator {
    @Override
    public int total() {
        return -1;
    }

    @Override
    public void add(String code) {

    }
}
