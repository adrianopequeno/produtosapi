package com.adriano.produtosapi.controller;

import com.adriano.produtosapi.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        System.out.println("Produto reecebido: " + product);
        return product;
    }
}
