package com.example.sportifyBackendNovo.demo.dto;

import com.example.sportifyBackendNovo.demo.model.Atleta;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtletaDTO {

    @NotBlank(message = "O nome de usuário não pode ser vazio.")
    @Pattern(regexp = "^[\\p{L}0-9_]{1,255}$", message = "Nome de usuário inválido, use apenas letras, números ou underscore e máx 255 chars.")
    private String nomeUsuario;

    @NotBlank(message = "Senha não pode ser vazia.")
    @Pattern(regexp = "^[\\p{L}0-9_]{6,255}$", message = "Senha inválida, use apenas letras, números ou underscore, min 6 chars e máx 255 chars.")
    private String senha;

    @NotBlank(message = "O nome não pode ser vazio.")
    @Pattern(regexp = "^[\\p{L}0-9_ ]{1,255}$", message = "Nome inválido, use apenas letras, números ou underscore e máx 255 chars.")
    private String nome;

    @Past(message = "Data de nascimento não pode ser no futuro.")
    private Date dataNascimento;

    @NotBlank(message = "Esporte não pode ser vazio.")
    @Pattern(regexp = "^[\\p{L}0-9_]{1,255}$", message = "Esporte inválido, use apenas letras, números ou underscore e máx 255 chars.")
    private String esporte;

    @Pattern(regexp = "[MF]", message = "Gênero inválido. Use 'M' ou 'F'.")
    private String genero;

    @Pattern(regexp = "\\d{14}", message = "CNPJ da Agência inválido.")
    private String agenciaCnpj;

    @Pattern(regexp = "\\d{14}", message = "CNPJ da Equipe inválido.")
    private String equipeCnpj;
}