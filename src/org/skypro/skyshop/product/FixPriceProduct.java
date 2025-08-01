package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return fixPrice;
    }

    public static final double fixPrice = 55;

    @Override
    public String toString() {
        return getName() + " с фиксированой ценой : " + getPrice() + " < " + fixPrice + " >";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
