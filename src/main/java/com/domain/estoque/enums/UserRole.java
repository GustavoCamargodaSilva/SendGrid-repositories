package com.domain.estoque.enums;

import com.domain.estoque.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
