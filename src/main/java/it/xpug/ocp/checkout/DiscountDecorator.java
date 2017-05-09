package it.xpug.ocp.checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DiscountDecorator implements PriceCalculator{

    private List<String> boughtItems = new ArrayList<>();
    private Map<String, UnitDiscount> unitDiscounts;

    public DiscountDecorator(PriceCalculator priceCalculator, Map<String, UnitDiscount> unitDiscounts) {

        this.unitDiscounts = unitDiscounts;
    }

    @Override
    public int total() {
        Map<String, Integer> itemQuantities = getItemQuantities();
        int totalDiscount = 0;
        for (String itemCode: itemQuantities.keySet()) {
            totalDiscount += unitDiscounts.get(itemCode).discountFor(itemQuantities.get(itemCode));
        }
        return totalDiscount;

    }

    private Map<String, Integer> getItemQuantities() {
//        Map<String, List<String>> frequencies = boughtItems.stream().collect(Collectors.groupingBy(itemCode -> itemCode));
//        return frequencies.;
//        HashMap<String, Integer> result = new HashMap<>();
//        boughtItems.stream().forEach(item ->
//                result.put()
//        );
        return null;
    }

    @Override
    public void add(String code) {
        boughtItems.add(code);
    }
}
