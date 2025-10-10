package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

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
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(name)) {
                    removedProducts.add(product);
                    iterator.remove();
                }
            }
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
        for (Product product: products) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    System.out.println("Товар есть в корзине");
                    return;
                }
            }
        System.out.println("Товар не найден");
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    public int countSpecialProducts() {
        int specialCount = 0;

        for (Product product: products) {
                if (product != null && product.isSpecial()) {
                    specialCount++;
                }
            }
        return specialCount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product product: products) {
                result.append(product.toString()).append("\n");
            }
        result.append("Итого: ").append(getTotalPrice()).append("\n");
        result.append("Специальных товаров: ").append(countSpecialProducts()).append("\n");
        return result.toString();
    }
}
