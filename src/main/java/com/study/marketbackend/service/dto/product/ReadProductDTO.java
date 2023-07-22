package com.study.marketbackend.service.dto.product;

import com.study.marketbackend.entity.product.Product;
import com.study.marketbackend.entity.product.ProductCategory;

public record ReadProductDTO(Long productCode, String productName, Double productPrice, ProductCategory productCategory, String productBrand, String productSupplier) {

    public ReadProductDTO(Product product) {
        this(product.getProductCode(), product.getProductName(), product.getProductPrice(), product.getProductCategory(), product.getProductBrand(), product.getProductSupplier());
    }
}
