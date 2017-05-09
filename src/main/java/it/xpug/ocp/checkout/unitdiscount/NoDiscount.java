package it.xpug.ocp.checkout.unitdiscount;

import it.xpug.ocp.checkout.decorators.Discount;

public class NoDiscount implements Discount {
    @Override
    public int registerItem() {
        return 0;
    }
}
