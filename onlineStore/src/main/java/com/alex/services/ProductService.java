package com.alex.services;

import com.alex.data.Product;
import com.alex.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteProductById(Long id){
        productRepository.deleteProductById(id);
    }

    public void changeCostById(Long id, Float delta){
        Product product = productRepository.findProductById(id);
        product.setCost(product.getCost()+delta);
    }
}
