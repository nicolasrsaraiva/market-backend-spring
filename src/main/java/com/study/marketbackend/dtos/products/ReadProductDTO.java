package com.study.marketbackend.dtos.products;

import com.study.marketbackend.models.product.Product;
import com.study.marketbackend.models.product.ProductCategory;

public record ReadProductDTO(Long productCode, String productName, Double productPrice, ProductCategory productCategory, String productBrand, String productSupplier) {

    public ReadProductDTO(Product product) {
        this(product.getProductCode(), product.getProductName(), product.getProductPrice(), product.getProductCategory(), product.getProductBrand(), product.getProductSupplier());
    }
}
