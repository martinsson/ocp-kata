package it.xpug.ocp.checkout;

import java.util.List;

public class UnitDiscount {

    private int requiredNumber;
    private int discountAmount;
    private int currentQuantity = 0;

    public UnitDiscount(int requiredNumber, int discountAmount) {
        this.requiredNumber = requiredNumber;

        this.discountAmount = discountAmount;
    }

    public Integer discountFor(Integer quantity) {
        return quantity >= requiredNumber ? discountAmount : 0;
    }

    public int registerItem() {
        currentQuantity++;
        if (currentQuantity % requiredNumber == 0) {
            return discountAmount;
        } else {
            return 0;
        }
    }
}
