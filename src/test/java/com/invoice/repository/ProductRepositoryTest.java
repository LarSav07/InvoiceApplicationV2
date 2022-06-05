package com.invoice.repository;

import com.invoice.entity.AccountHolder;
import com.invoice.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void saveProduct() {

        Product product =
                Product.builder()
                        .amount(50.00)
                        .price(50.00)
                        .productName("Stuff")
                        .build();

        productRepository.save(product);
    }
}