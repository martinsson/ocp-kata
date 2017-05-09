package it.xpug.ocp.checkout;

public class DummyPrice implements PriceCalculator {
    @Override
    public int total() {
        return -1;
    }

    @Override
    public void add(String code) {

    }
}
