package com.study.marketbackend.controllers;

import com.study.marketbackend.dtos.products.CreateProductDTO;
import com.study.marketbackend.models.product.Product;
import com.study.marketbackend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public void createProduct(@RequestBody @Valid CreateProductDTO createProductDTO){
        productRepository.save(new Product(createProductDTO));
    }

    @GetMapping
    public void readProducts(){
        productRepository.findAll();
    }
    @DeleteMapping("/{code}")
    public void deleteProduct(@PathVariable Long code){
        var product = productRepository.getReferenceById(code);
        productRepository.delete(product);
    }
}
