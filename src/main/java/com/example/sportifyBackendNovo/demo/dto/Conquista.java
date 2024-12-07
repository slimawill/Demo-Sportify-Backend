package com.example.sportifyBackendNovo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conquista {
    private String eventoNome;
    private String tipo;
    private String categoria;
    private String tipoParticipacao;
}