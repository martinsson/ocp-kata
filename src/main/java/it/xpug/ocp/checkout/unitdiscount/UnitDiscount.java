package it.xpug.ocp.checkout.unitdiscount;

import it.xpug.ocp.checkout.decorators.Discount;

public class UnitDiscount implements Discount {

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

    @Override
    public int registerItem() {
        currentQuantity++;
        if (currentQuantity % requiredNumber == 0) {
            return discountAmount;
        } else {
            return 0;
        }
    }
}