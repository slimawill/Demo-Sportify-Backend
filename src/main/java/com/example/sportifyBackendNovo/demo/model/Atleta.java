package com.example.sportifyBackendNovo.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SPF_ATLETA")
public class Atleta {

    @Id
    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;

    @Column(name = "SENHA")
    private String senha;
    
    @Column(name = "NOME", nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
    
    @Column(name = "ESPORTE", nullable = false)
    private String esporte;
    
    @Column(name = "GENERO")
    private Character genero;
    
    @Column(name = "AGENCIA_CNPJ")
    private String agenciaCnpj;
    
    @Column(name = "EQUIPE_CNPJ") 
    private String equipeCnpj;
}

