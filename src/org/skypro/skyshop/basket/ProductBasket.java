package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
            System.out.println(product.getName() + " добавлен в корзину");
        } else {
            System.out.println("Невозможно добавить продукт!");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void showBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто!");
        } else {
            System.out.println("Содержимое корзины:");
            for (int i = 0; i < count; i++) {
                System.out.println(products[i].getName() + " - " + products[i].getPrice());
            }
            System.out.println("Итого: " + getTotalPrice());
        }
    }

    public void isProductInBasket(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equalsIgnoreCase(productName)) {
                System.out.println("Товар есть в корзине");
                return;
            } else {
                System.out.println("Товар не найден");
                return;
            }

        }
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
            System.out.println(products[i]);
        }
        count = 0;
        System.out.println("Корзина очищена");
    }
}
