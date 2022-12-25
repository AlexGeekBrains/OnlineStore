package ru.alex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.alex.data.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("update Product p set p.cost = p.cost + :cost where p.id= :id")
    void changeCostById(@Param(value = "id") Long id, @Param(value = "cost") Integer cost);

    List<Product> findAllByCostGreaterThan(Integer cost);

    List<Product> findAllByCostLessThan(Integer cost);

    List<Product> findAllByCostBetween(Integer min, Integer max);
}