package com.study.marketbackend.service.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record LoginDTO(
        @Email @NotNull
        String email,
        @NotNull
        String password) {
}
