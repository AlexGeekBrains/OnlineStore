package ru.alex.repository.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import ru.alex.data.Product;

@Repository
public class ProductSpecification {
    public Specification<Product> costGreaterOrEqualsThan(Integer minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), minPrice);
    }

    public Specification<Product> costLessOrEqualsThan(Integer maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), maxPrice);
    }

    public Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%S%%", titlePart));
    }
}