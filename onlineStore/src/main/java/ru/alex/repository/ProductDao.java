package ru.alex.repository;

import org.springframework.stereotype.Component;
import ru.alex.data.Consumer;
import ru.alex.data.Product;

import java.util.List;
@Component
public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
    List<Consumer> getConsumersByProductsId(Long id);
}
