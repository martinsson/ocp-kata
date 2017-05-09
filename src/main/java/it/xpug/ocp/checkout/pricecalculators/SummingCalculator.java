package it.xpug.ocp.checkout.pricecalculators;

import it.xpug.ocp.checkout.PriceCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummingCalculator implements PriceCalculator {
    private Map<String, Integer> prices;
    private List<String> boughtItems = new ArrayList<>();

    public SummingCalculator(Map<String, Integer> prices) {
        this.prices = prices;
    }

    @Override
    public int total() {
        return boughtItems.stream()
                .map(prices::get)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public void add(String code) {
        boughtItems.add(code);
    }
}
