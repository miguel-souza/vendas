package io.github.yasminsouza.service.impl;

import io.github.yasminsouza.exception.NotFoundException;
import io.github.yasminsouza.model.Product;
import io.github.yasminsouza.repository.ProductRepository;
import io.github.yasminsouza.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado."));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.findById(id)
                .map(productExist -> {
                    productExist.setId(productExist.getId());
                    return productRepository.save(productExist);
                })
                .orElseThrow(() -> new NotFoundException("Produto não encontrado."));
    }

    @Override
    public void delete(Integer id) {
        productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new NotFoundException("Produto não encontrado."));
    }

    @Override
    public List<Product> getAll(String description, BigDecimal price) {
        return productRepository.findByDescriptionLikeOrPriceLike(description, price);
    }
}
