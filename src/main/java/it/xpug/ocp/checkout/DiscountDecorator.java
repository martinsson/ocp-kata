package it.xpug.ocp.checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiscountDecorator implements PriceCalculator {

    private List<String> boughtItems = new ArrayList<>();
    private PriceCalculator priceCalculator;
    private Map<String, UnitDiscount> unitDiscounts;

    public DiscountDecorator(PriceCalculator priceCalculator, Map<String, UnitDiscount> unitDiscounts) {
        this.priceCalculator = priceCalculator;
        this.unitDiscounts = unitDiscounts;
    }

    @Override
    public int total() {
        int discount = boughtItems.stream().mapToInt(item -> unitDiscounts.get(item).registerItem()).sum();
        return priceCalculator.total() - discount;
    }


    @Override
    public void add(String code) {
        boughtItems.add(code);
        priceCalculator.add(code);
    }
}
