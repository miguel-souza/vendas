package io.github.yasminsouza.repository;

import io.github.yasminsouza.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByDescriptionLikeOrPriceLike(String description, BigDecimal price);
}
