package com.domain.estoque.services;

import com.domain.estoque.dto.RegisterDTO;
import com.domain.estoque.entities.User;
import com.domain.estoque.enums.UserRole;
import com.domain.estoque.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //metodo consulta de email
        return repository.findByEmail(email);
    }

}
