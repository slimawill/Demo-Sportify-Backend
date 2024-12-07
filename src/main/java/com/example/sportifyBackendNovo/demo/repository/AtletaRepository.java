package com.example.sportifyBackendNovo.demo.repository;

import com.example.sportifyBackendNovo.demo.dto.AtletaDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sportifyBackendNovo.demo.model.Atleta;
import java.util.Optional;

@Repository
public interface AtletaRepository extends JpaRepository<Atleta, String> {
    @Query("SELECT a FROM Atleta a WHERE a.nomeUsuario = ?1 AND a.senha = ?2")
    Optional<Atleta> findByNomeUsuarioAndSenha(String nomeUsuario, String senha);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SPF_ATLETA (NOME_USUARIO, NOME, DATA_NASCIMENTO, ESPORTE, GENERO, AGENCIA_CNPJ, EQUIPE_CNPJ, SENHA) " +
            "VALUES (:nomeUsuario, :nome, :dataNascimento, :esporte, :genero, :agenciaCnpj, :equipeCnpj, :senha) ", nativeQuery = true)
    int registerAtleta(
            @Param("nomeUsuario") String nomeUsuario,
            @Param("nome") String nome,
            @Param("dataNascimento") java.util.Date dataNascimento,
            @Param("esporte") String esporte,
            @Param("genero") char genero,
            @Param("agenciaCnpj") String agenciaCnpj,
            @Param("equipeCnpj") String equipeCnpj,
            @Param("senha") String senha
    );

    @Query("SELECT a FROM Atleta a WHERE a.nomeUsuario = ?1")
    Optional<Atleta> findByNomeUsuario(String nomeUsuario);
}