package com.adriano.produtosapi.controller;

import com.adriano.produtosapi.model.Product;
import com.adriano.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        System.out.println("Produto reecebido: " + product);

        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);
        return product;
    }

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable("id") String id) {
//        Optional<Product> product = productRepository.findById(id);
//        return product.isPresent() ? product.get() : null;
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProductById(@PathVariable("id") String id) {
        productRepository.deleteById(id);
    }
}
