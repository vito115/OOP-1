package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {

    private List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public ProductBasket(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            System.out.println(product.getName() + " продукт удален из корзины");
        } else {
            System.out.println(product.getName() + " не найден в корзине");
        }
    }


    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
        products.removeAll(removedProducts);
        return removedProducts;
    }

    public void checkAndRemoveExistentProduct(String name) {
        List<Product> removeProducts = removeProductsByName(name);
        if (removeProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " добавлен в корзину");
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
            }
        return total;
    }

    public void showBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто!");
        } else {
            System.out.println("Содержимое корзины:");
            for (Product product: products) {
                    System.out.println(product.getName() + " - " + product.getPrice() + " руб.");
            }
            System.out.println("Итого: " + getTotalPrice() + " руб.");
        }
    }

    public void isProductInBasket(String productName) {
        boolean exists = products.stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(productName));

        if (exists) {
            System.out.println("Товар есть в корзине");
        } else {
            System.out.println("Товар не найден");
        }
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    public int countSpecialProducts() {

        return (int) products.stream()
                .filter(product -> product != null && product.isSpecial())
                .count();
    }

    @Override
    public String toString() {
        String productsString = products.stream()
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
        return productsString + "\nИтого: " + getTotalPrice() + "\n" +
                "Специальных товаров: " + countSpecialProducts() + "\n";
    }
}
