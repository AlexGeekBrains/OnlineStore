package ru.alex.repository;

import org.springframework.stereotype.Component;
import ru.alex.data.Consumer;
import ru.alex.data.Product;

import java.util.List;

@Component
public interface ConsumerDao {
    Consumer findConsumerById(Long id);

    List<Product> getProductsByConsumerId(Long id);

    List<Consumer> findAll();

    void deleteById(Long id);

    Consumer saveOrUpdate(Consumer product);
}
