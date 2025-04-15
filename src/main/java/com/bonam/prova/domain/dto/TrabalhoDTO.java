package com.bonam.prova.domain.dto;

import com.bonam.prova.domain.model.Trabalho;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrabalhoDTO {
    private Long id;
    private String nome;

    public Trabalho toObject(){
        return Trabalho.builder()
                .nome(nome)
                .id(id)
                .build();
    }
}
