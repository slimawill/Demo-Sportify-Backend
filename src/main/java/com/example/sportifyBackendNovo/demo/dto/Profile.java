package com.example.sportifyBackendNovo.demo.dto;

import com.example.sportifyBackendNovo.demo.model.Atleta;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Profile {
    private Atleta atleta;
    private List<ConquistaDTOExternal> conquistas;
}