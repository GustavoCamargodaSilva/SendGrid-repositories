package com.domain.sendgrid.dto;

import com.domain.sendgrid.enums.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}