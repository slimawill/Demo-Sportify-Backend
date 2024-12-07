package com.example.sportifyBackendNovo.demo.repository;

import com.example.sportifyBackendNovo.demo.dto.Conquista;
import com.example.sportifyBackendNovo.demo.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Atleta, String> {

    @Query(value = "SELECT " +
            "ev.nome AS eventoNome, " +
            "premin.tipo AS tipo, " +
            "premin.categoria AS categoria, " +
            "'Individual' AS tipoParticipacao " +
            "FROM SPF_PARTICIPACAO_INDIVIDUAL pi " +
            "JOIN SPF_EVENTO ev ON ev.ID = pi.EVENTO_ID " +
            "JOIN SPF_PREMIACAO_INDIVIDUAL premin ON premin.ID_PARTICIPACAO = pi.ID " +
            "WHERE pi.NOME_USUARIO = :nomeUsuario " +
            "UNION ALL " +
            "SELECT " +
            "ev.nome AS eventoNome, " +
            "preme.tipo AS tipo, " +
            "preme.categoria AS categoria, " +
            "'Equipe' AS tipoParticipacao " +
            "FROM SPF_PARTICIPACAO_EQUIPE pce " +
            "JOIN SPF_EVENTO ev ON ev.ID = pce.EVENTO_ID " +
            "JOIN SPF_PREMIACAO_EQUIPE preme ON preme.ID_PARTICIPACAO = pce.ID " +
            "WHERE pce.NOME_USUARIO = :nomeUsuario ",
            nativeQuery = true)
    List<Conquista> getConquistas(@Param("nomeUsuario") String nomeUsuario);
}