package com.example.sportifyBackendNovo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostagemDTO {
    private Long id;
    private String nomeUsuario;
    private LocalDateTime dataHora;
    private Integer curtidas;
    private Integer comentarios;
    private String conteudos;
    private String image;

    public PostagemDTO(BigDecimal id,
                       String nomeUsuario,
                       Timestamp dataHora,
                       BigDecimal curtidas,
                       BigDecimal comentarios,
                       String conteudos) {
        this.id = id.longValue();
        this.nomeUsuario = nomeUsuario;
        this.dataHora = dataHora.toLocalDateTime();
        this.curtidas = curtidas.intValue();
        this.comentarios = comentarios.intValue();
        this.conteudos = conteudos;
    }
}