package com.example.sportifyBackendNovo.demo.service;

import com.example.sportifyBackendNovo.demo.dto.PostagemDTO;
import com.example.sportifyBackendNovo.demo.repository.AtletaRepository;
import com.example.sportifyBackendNovo.demo.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemService {

    private final PostagemRepository postagemRepository;

    @Autowired
    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public List<PostagemDTO> getPostagens(){
        List<PostagemDTO> postagemResponse = postagemRepository.getPostagens();
        for (var element : postagemResponse){
            String[] parts = element.getConteudos().split(",");
            element.setConteudos(null);
            element.setImage(null);
            for (String part : parts){
                if (part.trim().startsWith("http://") || part.trim().startsWith("https://")){
                    element.setImage(part);
                } else {
                    element.setConteudos(part);
                }
            }
        }
        return postagemResponse;
    }
}
