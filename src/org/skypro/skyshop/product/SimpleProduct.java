package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final double price;

    public SimpleProduct(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
