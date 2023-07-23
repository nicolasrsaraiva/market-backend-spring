package com.study.marketbackend.controller;

import com.study.marketbackend.service.dto.product.CreateProductDTO;
import com.study.marketbackend.service.dto.product.ReadProductDTO;
import com.study.marketbackend.service.dto.product.UpdateProductDTO;
import com.study.marketbackend.entity.product.Product;
import com.study.marketbackend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createProduct(@RequestBody @Valid CreateProductDTO createProductDTO){
        productRepository.save(new Product(createProductDTO));
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> updateProduct(@RequestBody @Valid UpdateProductDTO updateProductDTO){
        var product = productRepository.getReferenceById(updateProductDTO.productCode());
        product.updateProductPrice(updateProductDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ReadProductDTO>> readProducts(){
        List<Product> products = productRepository.findAll();
        var response = products.stream().map(ReadProductDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long code){
        var product = productRepository.getReferenceById(code);
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
