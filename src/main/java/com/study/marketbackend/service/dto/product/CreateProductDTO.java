package com.study.marketbackend.service.dto.product;

import com.study.marketbackend.entity.product.ProductCategory;
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
