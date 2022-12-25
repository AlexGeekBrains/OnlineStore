package ru.alex.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.data.Product;
import ru.alex.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void changeCostById(Long productId, Integer delta) {
        productRepository.changeCostById(productId, delta);
    }

    public List<Product> moreThanMinCost(Integer minCost) {
        return productRepository.findAllByCostGreaterThan(minCost);
    }

    public List<Product> lessThanMaxCost(Integer maxCost) {
        return productRepository.findAllByCostLessThan(maxCost);
    }

    public List<Product> findAllByCostBetween(Integer minCost, Integer maxCost) {
        return productRepository.findAllByCostBetween(minCost, maxCost);
    }
}