package com.example.sportifyBackendNovo.demo.controller;

import com.example.sportifyBackendNovo.demo.dto.PostagemDTO;
import com.example.sportifyBackendNovo.demo.service.PostagemService;
import com.example.sportifyBackendNovo.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/postagem")
public class PostagemController {

    private final PostagemService postagemService;

    @Autowired
    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @GetMapping()
    public List<PostagemDTO> getPostagem() {
        return postagemService.getPostagens();
    }
}
