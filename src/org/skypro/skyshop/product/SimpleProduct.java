package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final double price;

    public SimpleProduct(String name, double price) {
        super(name);
        this.price = price;
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше нуля");
        }
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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
