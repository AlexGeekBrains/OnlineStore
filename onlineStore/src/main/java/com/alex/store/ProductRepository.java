package com.alex.store;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1,"Potatoes",20.04f));
        products.add(new Product(2,"Milk",100.55f));
        products.add(new Product(3,"Eggs",50.78f));
        products.add(new Product(4,"Pancake",72.40f));
        products.add(new Product(5,"Paper",18.25f));
    }

    public Product findById(int id){
        return products.stream().filter(p -> p.getId()==id).findFirst().orElseThrow(()->new RuntimeException("product not found"));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
