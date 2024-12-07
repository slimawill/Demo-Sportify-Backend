package com.example.sportifyBackendNovo.demo.dto;

import com.example.sportifyBackendNovo.demo.model.Atleta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtletaDTO {
    private String nomeUsuario;
    private String senha;
    private String nome;
    private Date dataNascimento;
    private String esporte;
    private char genero;
    private String agenciaCnpj;
    private String equipeCnpj;

}