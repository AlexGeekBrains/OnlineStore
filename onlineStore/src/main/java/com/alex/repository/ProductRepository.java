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
                new Product(1L, "Potatoes", 20.04f),
                new Product(2L, "Milk", 100.55f),
                new Product(3L, "Eggs", 50.78f),
                new Product(4L, "Pancake", 72.40f),
                new Product(5L, "Paper", 18.25f)));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProductById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product findProductById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("product not found"));
    }
}