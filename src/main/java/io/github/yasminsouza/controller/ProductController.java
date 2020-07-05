package io.github.yasminsouza.controller;

import io.github.yasminsouza.model.Product;
import io.github.yasminsouza.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id){
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Product product){
        productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }

    @GetMapping
    public List<Product> getAll(@RequestParam(required = false, defaultValue = "") String description,
                                @RequestParam(required = false) BigDecimal price){
        return productService.getAll(description, price);
    }
}
