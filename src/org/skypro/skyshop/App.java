package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchableNameComparator;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;

import java.util.*;

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

//            try {
//                Product meet = new DiscountedProduct("Мясо", -100, 30);
//                System.out.println("Добавлен продукт " + meet);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Ошибка у продукта " + e.getMessage());
//            }
//            try {
//                Product juice = new SimpleProduct(" ", -100);
//                System.out.println("Добавлен продукт " + juice);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Ошибка у продукта " + e.getMessage());
//            }


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

            //Searchable[] results = searchEngine.search("Товары").toArray(new Searchable[0]);

            Set<Searchable> itemsSet = new HashSet<>();
            Set<Searchable> results = searchEngine.search("Товары");

            System.out.println("Результаты поиска:");
            for (Searchable item : results) {
                System.out.println("Имя: " + item.getName() + " Объект " + item);
            }

            itemsSet.add(avocado);
            itemsSet.add(melon);
            itemsSet.add(watermelon);
            itemsSet.add(notebook);
            itemsSet.add(book);

            try {
                Searchable bestMatch = searchEngine.findBestMatch("Avocado", itemsSet);
                System.out.println("Найден товар " + bestMatch);
            } catch (BestResultNotFoundException e) {
                System.out.println(e.getMessage());
            }
            try {
                Searchable bestMatch = searchEngine.findBestMatch("Неизвестный товар", itemsSet);
                System.out.println("Найден товар " + bestMatch);
            } catch (BestResultNotFoundException e) {


                
                System.out.println(e.getMessage());
            }

            System.out.println("List");

            productBasket.removeProduct(milk);
            productBasket.showBasket();
            productBasket.checkAndRemoveExistentProduct("Пианино");
            productBasket.showBasket();

            System.out.println("Map");

            System.out.println(productBasket);

            Set<Article> articles = new TreeSet<>(new SearchableNameComparator());

            articles.add(new Article("Oneplus -", "Smartphone"));
            articles.add(new Article("PlayStaytion -", "GameConsole"));
            articles.add(new Article("LG -", "Projector"));

            System.out.println("Отсортированные статьи:");
            for (Article article : articles) {
                System.out.println(article);
            }
        }
    }
}
