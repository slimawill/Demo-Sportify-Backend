package com.example.sportifyBackendNovo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ConquistaDTOExternal {
    private String eventoNome;
    private List<String> premiacoes;
}
