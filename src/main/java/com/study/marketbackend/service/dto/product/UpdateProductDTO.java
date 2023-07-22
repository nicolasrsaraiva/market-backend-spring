package com.study.marketbackend.service.dto.product;

import jakarta.validation.constraints.NotNull;


public record UpdateProductDTO (
        @NotNull
        Long productCode,
        Double productPrice
) {
}
