package io.github.yasminsouza.service;

import io.github.yasminsouza.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ProductService {
    Product findById(Integer id);
    Product save(Product product);
    void update(Integer id, Product product);
    void delete(Integer id);
    List<Product> getAll(String description, BigDecimal price);
}
