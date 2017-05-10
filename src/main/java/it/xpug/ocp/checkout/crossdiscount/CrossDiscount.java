package it.xpug.ocp.checkout.crossdiscount;

import java.util.List;

public class CrossDiscount {
    private final String discountee;
    private final String discounter;
    private final int minQuantity;
    private final int amount;

    public CrossDiscount(String discountee, String discounter, int minQuantity, int amount) {

        this.discountee = discountee;
        this.discounter = discounter;
        this.minQuantity = minQuantity;
        this.amount = amount;
    }

    public int discount(List<String> shoppingBasket) {
        long numberOfDiscounters = shoppingBasket.stream()
                .filter(item -> discounter.equals(item))
                .count();
        if (shoppingBasket.contains(discountee) && numberOfDiscounters >= minQuantity) {
            return amount;
        }
        return 0;
    }
}
