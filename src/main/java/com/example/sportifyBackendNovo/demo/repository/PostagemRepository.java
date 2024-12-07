package com.example.sportifyBackendNovo.demo.repository;

import com.example.sportifyBackendNovo.demo.dto.Conquista;
import com.example.sportifyBackendNovo.demo.dto.PostagemDTO;
import com.example.sportifyBackendNovo.demo.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Atleta, String> {

    @Query(value = "SELECT * " +
            "FROM ( " +
            "SELECT p.ID, " +
            "p.NOME_USUARIO, " +
            "p.DATA_HORA, " +
            "p.CURTIDAS, " +
            "p.COMENTARIOS, " +
            "LISTAGG(m.CONTEUDO, ', ') WITHIN GROUP (ORDER BY m.CONTEUDO) AS CONTEUDOS " +
            "FROM SPF_POSTAGEM p " +
            "LEFT JOIN SPF_MIDIA m ON p.ID = m.POSTAGEM_ID " +
            "GROUP BY p.ID, p.NOME_USUARIO, p.DATA_HORA, p.CURTIDAS, p.COMENTARIOS " +
            "ORDER BY p.CURTIDAS DESC, p.DATA_HORA DESC " +
            ") " +
            "WHERE ROWNUM <= 3 ",
            nativeQuery = true)
    List<PostagemDTO> getPostagens();
}

