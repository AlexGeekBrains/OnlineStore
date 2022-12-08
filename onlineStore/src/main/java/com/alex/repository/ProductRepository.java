package com.alex.repository;

import com.alex.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1, "Potatoes", 20.04f),
                new Product(2, "Milk", 100.55f),
                new Product(3, "Eggs", 50.78f),
                new Product(4, "Pancake", 72.40f),
                new Product(5, "Paper", 18.25f)));
    }

    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("product not found"));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}