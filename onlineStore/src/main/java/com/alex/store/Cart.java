package com.alex.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> products;
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductCartById(int id) {
        products.add(productRepository.findById(id));
    }

    public void removeProductCartById(int id) {
        products.remove(products.stream().filter(product -> product.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Product not found")));
    }

    @Override
    public String toString() {
        return "Cart" + products ;
    }
}
