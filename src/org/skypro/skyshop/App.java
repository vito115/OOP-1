package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {

    public static class Main {

        public static void main(String[] args) {

            ProductBasket productBasket = new ProductBasket();
            Product milk = new Product("Молоко", 80);
            Product bread = new Product("Хлеб", 50);
            Product water = new Product("Вода", 40);
            Product apple = new Product("Яблоко", 120);
            Product iceCream = new Product("Мороженое", 60);
            Product vine = new Product("Вино", 60);

            productBasket.addProduct(milk);
            productBasket.addProduct(bread);
            productBasket.addProduct(water);
            productBasket.addProduct(apple);
            productBasket.addProduct(iceCream);

            productBasket.addProduct(vine);

            productBasket.showBasket();

            productBasket.getTotalPrice();

            productBasket.isProductInBasket(milk.getName());

            productBasket.isProductInBasket(vine.getName());

            productBasket.clearBasket();

            productBasket.showBasket();

            productBasket.getTotalPrice();

            productBasket.isProductInBasket(milk.getName());

        }
    }
}
