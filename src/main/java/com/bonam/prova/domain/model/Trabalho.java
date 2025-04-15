package com.bonam.prova.domain.model;

import com.bonam.prova.domain.dto.TrabalhoDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@Entity(name = "TRABALHO")
@NoArgsConstructor
@AllArgsConstructor
public class Trabalho {
    @Id
    private Long id;
    @Column(name = "NOME")
    private String nome;

    public TrabalhoDTO toDto(){
        return TrabalhoDTO.builder()
                .id(id)
                .nome(nome)
                .build();
    }
}
