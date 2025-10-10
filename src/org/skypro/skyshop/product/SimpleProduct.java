package org.skypro.skyshop.product;

import java.util.Objects;

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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        SimpleProduct that = (SimpleProduct) obj;
        return Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
