package org.example.AssignmentMod4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiOpr {
    public static void main(String[] args) {


        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200, "Electronics"),
                new Product("Smartphone", 800, "Electronics"),
                new Product("Desk", 200, "Furniture"),
                new Product("Chair", 150, "Furniture"),
                new Product("TV", 1000, "Electronics"),
                new Product("Blender", 50, "Appliances"),
                new Product("Oven", 1200, "Appliances")
        );

        // 1. Find all products that have a price greater than 1000
        List<Product> expensiveProducts = products.stream()
                .filter(product -> product.getPrice() > 1000)
                .collect(Collectors.toList());
        System.out.println("Products with price greater than 1000: " + expensiveProducts);

        // 2. Calculate the total price of all products in the list
        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total price of all products: " + totalPrice);

        // 3. Find the product with the highest price
        Product highestPricedProduct = products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElse(null);
        System.out.println("Product with the highest price: " + highestPricedProduct);

        // 4. Create a list of product names sorted alphabetically
        List<String> sortedProductNames = products.stream()
                .map(Product::getName)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Product names sorted alphabetically: " + sortedProductNames);

        // 5. Count the number of products in each category
        Map<String, Long> productCountByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Number of products in each category: " + productCountByCategory);
    }
}
