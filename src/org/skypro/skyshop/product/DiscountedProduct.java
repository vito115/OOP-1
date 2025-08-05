package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final double basicPrice;
    private final int percentDiscount;

    public DiscountedProduct(String name, double basicPrice, int percentDiscount) {
        super(name);
        this.basicPrice = basicPrice;
        this.percentDiscount = percentDiscount;
    }

    @Override
    public double getPrice() {
        return basicPrice * (1 - percentDiscount / 100.0);
    }

    @Override
    public String toString() {
        return getName() + " со скидкой > : " + getPrice() + ("<" + percentDiscount + "> %");
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
