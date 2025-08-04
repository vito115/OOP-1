package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    public static final double FIX_PRICE = 55;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + " с фиксированой ценой : " + getPrice() + " < " + FIX_PRICE + " >";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
