package it.xpug.ocp.checkout;

public interface PriceCalculator {
    int total();

    void add(String code);
}
