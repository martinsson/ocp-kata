package it.xpug.ocp.checkout.unitdiscount;

public class NoDiscount implements Discount {
    @Override
    public int registerItem() {
        return 0;
    }
}
