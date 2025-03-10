package com.adriano.produtosapi.controller;

import com.adriano.produtosapi.model.Product;
import com.adriano.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping(value = "/{id}")
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getProductByRequestParam(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) Double price
    ) {
        if (name != null) {
            return productRepository.findByName(name);
        }
        if (price != null) {
            return productRepository.findByPrice(price);
        }
        return productRepository.findAll();
    }
}
