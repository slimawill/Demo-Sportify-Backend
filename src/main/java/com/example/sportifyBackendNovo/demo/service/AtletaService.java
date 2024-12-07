package com.example.sportifyBackendNovo.demo.service;

import com.example.sportifyBackendNovo.demo.dto.AtletaDTO;
import com.example.sportifyBackendNovo.demo.exceptions.NotFoundException;
import com.example.sportifyBackendNovo.demo.exceptions.RegistrationFailedException;
import com.example.sportifyBackendNovo.demo.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sportifyBackendNovo.demo.repository.AtletaRepository;
import com.example.sportifyBackendNovo.demo.model.Atleta;

@Service
public class AtletaService {

    private final AtletaRepository atletaRepository;

    private Atleta createAtletaFromDTO(AtletaDTO atletaDTO){
        Atleta atleta = new Atleta(
                atletaDTO.getNomeUsuario(),
                atletaDTO.getSenha(),
                atletaDTO.getNome(),
                atletaDTO.getDataNascimento(),
                atletaDTO.getEsporte(),
                atletaDTO.getGenero() != null ? atletaDTO.getGenero().charAt(0) : null,
                atletaDTO.getAgenciaCnpj(),
                atletaDTO.getEquipeCnpj());
        return atleta;
    }

    @Autowired
    public AtletaService(AtletaRepository atletaRepository) {
        this.atletaRepository = atletaRepository;
    }

    public Atleta authenticateAtleta(String nomeUsuario, String senha) {
        return atletaRepository.findByNomeUsuarioAndSenha(nomeUsuario, senha)
                .orElseThrow(() -> new UnauthorizedException("Invalid username or password"));
    }

    public Atleta registerAtleta(AtletaDTO atletaDTO) {
        Atleta atleta = createAtletaFromDTO(atletaDTO);
        int response = atletaRepository.registerAtleta(atleta.getNomeUsuario(),
                atleta.getNome(),
                atleta.getDataNascimento(),
                atleta.getEsporte(),
                atleta.getGenero(),
                atleta.getAgenciaCnpj(),
                atleta.getEquipeCnpj(),
                atleta.getSenha());
        System.out.println(atleta.getGenero());
        if (response != 1) {
            throw new RegistrationFailedException("Erro ocorrido no cadastro de novo atleta");
        }
        return atleta;
    }

    public  Atleta findByNomeUsuario(String nomeUsuario){
        return atletaRepository.findByNomeUsuario(nomeUsuario)
                .orElseThrow(() -> new NotFoundException("O usuario não existe"));
    }

} 