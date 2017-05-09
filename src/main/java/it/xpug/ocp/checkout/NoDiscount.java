package it.xpug.ocp.checkout;

class NoDiscount implements Discount {
    @Override
    public int registerItem() {
        return 0;
    }
}
