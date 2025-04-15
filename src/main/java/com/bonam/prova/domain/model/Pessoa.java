package com.bonam.prova.domain.model;

import com.bonam.prova.domain.dto.PessoaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@Entity(name = "PESSOA")
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    private Long id;
    @Column(name = "NOME")
    private String nome;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Trabalho> trabalhos;

    public PessoaDTO toDto(){
        return PessoaDTO.builder()
                .id(id)
                .trabalhos(trabalhos.stream().map(Trabalho::toDto).toList())
                .build();
    }
}
