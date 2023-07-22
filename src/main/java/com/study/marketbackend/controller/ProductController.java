package com.study.marketbackend.controller;

import com.study.marketbackend.service.dto.product.CreateProductDTO;
import com.study.marketbackend.service.dto.product.ReadProductDTO;
import com.study.marketbackend.service.dto.product.UpdateProductDTO;
import com.study.marketbackend.entity.product.Product;
import com.study.marketbackend.repository.ProductRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public void createProduct(@RequestBody @Valid CreateProductDTO createProductDTO){
        productRepository.save(new Product(createProductDTO));
    }

    @PutMapping
    @Transactional
    public void updateProduct(@RequestBody @Valid UpdateProductDTO updateProductDTO){
        var product = productRepository.getReferenceById(updateProductDTO.productCode());
        product.updateProductPrice(updateProductDTO);
    }

    @GetMapping
    public List<ReadProductDTO> readProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ReadProductDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping("/{code}")
    public void deleteProduct(@PathVariable Long code){
        var product = productRepository.getReferenceById(code);
        productRepository.delete(product);
    }
}
