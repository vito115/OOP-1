package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private List<List<Product>> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
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

        for (List<Product> productList : products) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(name)) {
                    removedProducts.add(product);
                    iterator.remove();
                }
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
        if (products.isEmpty()) {
            List<Product> newProductList = new ArrayList<>();
            newProductList.add(product);
            products.add((List<Product>) newProductList);
        } else {
            products.get(0).add(product);
        }
        System.out.println(product.getName() + " добавлен в корзину");
    }

    public double getTotalPrice() {
        double total = 0;
        for (List<Product> productList: products) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void showBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто!");
        } else {
            System.out.println("Содержимое корзины:");
            for (List<Product> productList: products) {
                for (Product product : productList) {
                    System.out.println(product.getName() + " - " + product.getPrice() + " руб.");
                }
            }
            System.out.println("Итого: " + getTotalPrice() + " руб.");
        }
    }

    public void isProductInBasket(String productName) {
        for (List<Product> productList: products) {
            for (Product product : productList) {

                if (product.getName().equalsIgnoreCase(productName)) {
                    System.out.println("Товар есть в корзине");
                    return;
                }
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

        for (List<Product> productList: products) {
            for (Product product : productList) {

                if (product != null && product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (List<Product> productList: products) {
            for (Product product : productList) {

                result.append(product.toString()).append("\n");
            }
        }
        result.append("Итого: ").append(getTotalPrice()).append("\n");
        result.append("Специальных товаров: ").append(countSpecialProducts()).append("\n");
        return result.toString();
    }
}
