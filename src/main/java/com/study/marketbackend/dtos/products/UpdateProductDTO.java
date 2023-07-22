package com.study.marketbackend.dtos.products;

import jakarta.validation.constraints.NotNull;


public record UpdateProductDTO (
        @NotNull
        Long productCode,
        Double productPrice
) {
}
