package com.example.sportifyBackendNovo.demo.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@RequiredArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Nome de usuário não pode ser vazio.")
    @Pattern(regexp = "^[\\p{L}0-9_]{1,255}$", message = "Nome de usuário inválido, use apenas letras, números ou underscore, máx 255 chars.")
    private String nomeUsuario;

    @NotBlank(message = "Senha não pode ser vazia.")
    @Pattern(regexp = "^[\\p{L}0-9_]{6,255}$", message = "Senha inválida, use apenas letras, números ou underscore, min 6 chars e máx 255 chars.")
    private String senha;

    public LoginRequest(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

}