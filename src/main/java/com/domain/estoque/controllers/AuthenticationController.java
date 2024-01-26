package com.domain.estoque.controllers;

import com.domain.estoque.dto.AuthenticationDTO;
import com.domain.estoque.dto.RegisterDTO;
import com.domain.estoque.entities.User;
import com.domain.estoque.enums.UserRole;
import com.domain.estoque.repositories.UserRepository;
import com.domain.estoque.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/home")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthorizationService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

       //var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity register(@RequestBody RegisterDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.email(), encryptedPassword, data.role());
        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
