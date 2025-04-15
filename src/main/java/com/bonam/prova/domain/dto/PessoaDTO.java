package com.bonam.prova.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private Long id;
    private String name;
    private List<TrabalhoDTO> trabalhos;
}
