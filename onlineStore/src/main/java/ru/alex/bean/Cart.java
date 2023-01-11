package ru.alex.bean;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.alex.converters.ProductConverter;
import ru.alex.dto.ProductDto;
import ru.alex.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class Cart {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private List<ProductDto> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }

    public List<ProductDto> addProductCartById(Long id) {
        products.add(productConverter.entityToDto(productRepository.findById(id).get()));
        return products;
    }

    public List<ProductDto> removeProductFromCartById(Long id) {
        products.remove(products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Product not found")));
        return products;
    }

    public List<ProductDto> getProducts() {
        return Collections.unmodifiableList(products);
    }
}