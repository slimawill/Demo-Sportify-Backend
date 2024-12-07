package com.example.sportifyBackendNovo.demo.controller;

import com.example.sportifyBackendNovo.demo.dto.ConquistaDTOExternal;
import com.example.sportifyBackendNovo.demo.dto.Profile;
import com.example.sportifyBackendNovo.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{nomeUsuario}/conquistas")
    public ResponseEntity<List<ConquistaDTOExternal>> getConquistas(@PathVariable String nomeUsuario){
        List<ConquistaDTOExternal> conquistaResponse = profileService.getConquistas(nomeUsuario);
        return ResponseEntity.ok().body(conquistaResponse);
    }

    @GetMapping("/{nomeUsuario}")
    public ResponseEntity<Profile> getFullProfile(@PathVariable String nomeUsuario){
        Profile profileResponse = profileService.getFullProfile(nomeUsuario);
        return ResponseEntity.ok().body(profileResponse);
    }
}
