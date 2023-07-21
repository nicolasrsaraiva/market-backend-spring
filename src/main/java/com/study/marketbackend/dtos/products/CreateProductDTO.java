package com.study.marketbackend.dtos.products;

import com.study.marketbackend.models.product.ProductCategory;
import jakarta.validation.constraints.NotNull;

public record CreateProductDTO(
        @NotNull
        String productName,
        @NotNull
        Double productPrice,
        @NotNull
        ProductCategory productCategory,
        @NotNull
        String productBrand,
        @NotNull
        String productSupplier
) {
}
