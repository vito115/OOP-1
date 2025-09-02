package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

public class App {

    public static class Main {

        public static void main(String[] args) {

            ProductBasket productBasket = new ProductBasket();
            Product milk = new SimpleProduct("Молоко", 80);
            Product bread = new SimpleProduct("Хлеб", 50);
            Product water = new SimpleProduct("Вода", 40);
            Product apple = new SimpleProduct("Яблоко", 120);
            Product iceCream = new SimpleProduct("Мороженое", 60);
            Product vine = new SimpleProduct("Вино", 60);

            Product hammer = new FixPriceProduct("Молоток");
            Product ball = new DiscountedProduct("Мяч", 1000, 70);

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

            productBasket.addProduct(milk);
            productBasket.addProduct(bread);
            productBasket.addProduct(water);
            productBasket.addProduct(apple);
            productBasket.addProduct(iceCream);

            productBasket.addProduct(hammer);
            productBasket.addProduct(ball);

            productBasket.showBasket();
            productBasket.countSpecialProducts();
            System.out.println(productBasket.countSpecialProducts());


            System.out.println("Polymorfism!");

            SearchEngine searchEngine = new SearchEngine();

            Product avocado = new SimpleProduct("Avocado", 120);
            Product melon = new SimpleProduct("Melon", 300);
            Product watermelon = new DiscountedProduct("Watermelon", 250, 25);

            searchEngine.add(avocado);
            searchEngine.add(melon);
            searchEngine.add(watermelon);

            Article notebook = new Article("Acer", "Игровой ноутбук");
            Article book = new Article("Plov", "Кулинария");

            searchEngine.add(notebook);
            searchEngine.add(book);

            Searchable[] results = searchEngine.search("Товары");

        }
    }
}
