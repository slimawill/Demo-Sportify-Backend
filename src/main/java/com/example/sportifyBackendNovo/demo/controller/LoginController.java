package com.example.sportifyBackendNovo.demo.controller;

import com.example.sportifyBackendNovo.demo.dto.AtletaDTO;
import com.example.sportifyBackendNovo.demo.model.Atleta;
import com.example.sportifyBackendNovo.demo.service.AtletaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sportifyBackendNovo.demo.dto.LoginRequest;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final AtletaService atletaService;

    @Autowired
    public LoginController(AtletaService atletaService) {
        this.atletaService = atletaService;
    }

    @PostMapping("/login")
    public ResponseEntity<Atleta> processLogin(@Valid @RequestBody LoginRequest loginRequest) {
        Atleta atletaResponse = atletaService.authenticateAtleta(loginRequest.getNomeUsuario(), loginRequest.getSenha());

        return ResponseEntity.ok().body(atletaResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<Atleta> processRegister(@Valid @RequestBody AtletaDTO atletaDTO) {
        Atleta atleta = atletaService.registerAtleta(atletaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(atleta);

    }
}