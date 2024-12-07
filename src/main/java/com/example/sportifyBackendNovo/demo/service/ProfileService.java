package com.example.sportifyBackendNovo.demo.service;

import com.example.sportifyBackendNovo.demo.dto.AtletaDTO;
import com.example.sportifyBackendNovo.demo.dto.Conquista;
import com.example.sportifyBackendNovo.demo.dto.ConquistaDTOExternal;
import com.example.sportifyBackendNovo.demo.dto.Profile;
import com.example.sportifyBackendNovo.demo.exceptions.NotFoundException;
import com.example.sportifyBackendNovo.demo.model.Atleta;
import com.example.sportifyBackendNovo.demo.repository.AtletaRepository;
import com.example.sportifyBackendNovo.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final AtletaRepository atletaRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, AtletaRepository atletaRepository) {
        this.profileRepository = profileRepository;
        this.atletaRepository = atletaRepository;
    }

    private Atleta createAtletaFromDTO(AtletaDTO atletaDTO){
        Atleta atleta = new Atleta(
                atletaDTO.getNomeUsuario(),
                atletaDTO.getSenha(),
                atletaDTO.getNome(),
                atletaDTO.getDataNascimento(),
                atletaDTO.getEsporte(),
                atletaDTO.getGenero(),
                atletaDTO.getAgenciaCnpj(),
                atletaDTO.getEquipeCnpj());
        return atleta;
    }

    public List<ConquistaDTOExternal> getConquistas(String nomeUsuario){
        List<Conquista> listConquistas = profileRepository.getConquistas(nomeUsuario);

        Map<String,List<String>> conquistas = new HashMap<>();

        for (var element : listConquistas){
            String nomeEvento = element.getEventoNome();
            String descricaoConquista = element.getCategoria() + " na categoria " + element.getTipo() + " " + element.getTipoParticipacao();

        if (conquistas.containsKey(nomeEvento)) {
            conquistas.get(nomeEvento).add(descricaoConquista);
        } else {
            List<String> novaLista = new ArrayList<>();
            novaLista.add(descricaoConquista);
            conquistas.put(nomeEvento, novaLista);
        }}

        List<ConquistaDTOExternal> listaConquistasExternal = new ArrayList<>();

        for (var element : conquistas.keySet()){
            listaConquistasExternal.add(new ConquistaDTOExternal(element, conquistas.get(element)));
        }

        return listaConquistasExternal;
    }

    public Profile getFullProfile(String nomeUsuario){
        List<ConquistaDTOExternal> conquistas = getConquistas(nomeUsuario);

        Atleta atletaResponse = atletaRepository.findByNomeUsuario(nomeUsuario)
                .orElseThrow(() -> new NotFoundException("Contato não encontrado"));


        atletaResponse.setSenha("Senha não disponível para esse tipo de consulta");
        return new Profile(atletaResponse, conquistas);
    }
}