package com.adriano.produtosapi.repository;

import com.adriano.produtosapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByName(String name);

    List<Product> findByPrice(Double price);
}
