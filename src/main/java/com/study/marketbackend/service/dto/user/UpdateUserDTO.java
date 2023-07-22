package com.study.marketbackend.service.dto.user;

import jakarta.validation.constraints.NotNull;

public record UpdateUserDTO(
        @NotNull
        Long id,
        String firstName,
        String lastName,
        String email,
        String password) {
}
