package ru.alex.converters;

import org.springframework.stereotype.Component;
import ru.alex.data.Product;
import ru.alex.dto.ProductDto;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
}