package com.example.sportifyBackendNovo.demo.dto;

import lombok.*;

@Data
@RequiredArgsConstructor
public class LoginRequest {
    private String nomeUsuario;
    private String senha;

    public LoginRequest(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

}