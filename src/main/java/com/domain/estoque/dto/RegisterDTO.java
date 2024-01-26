package com.domain.estoque.dto;

import com.domain.estoque.enums.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}