package com.bonam.prova.domain.service;

import com.bonam.prova.domain.dto.PessoaDTO;
import com.bonam.prova.domain.dto.TrabalhoDTO;
import com.bonam.prova.domain.model.Pessoa;
import com.bonam.prova.domain.model.Trabalho;
import com.bonam.prova.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public List<PessoaDTO> getAllPessoas() {
        var response = pessoaRepository.findAll();
        return response.stream().map(Pessoa::toDto).toList();
    }

    public PessoaDTO getPessoaById(Long id) {
        var pessoa = pessoaRepository.findById(id).orElseThrow();
        return pessoa.toDto();
    }

    public PessoaDTO savePessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDTO.getName())
                .trabalhos(pessoaDTO.getTrabalhos().stream().map(TrabalhoDTO::toObject).toList())
                .build();
        var response = pessoaRepository.save(pessoa);
        return response.toDto();
    }

    public PessoaDTO updatePessoa(Long id, PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow();
        pessoa.setNome(pessoaDTO.getName());
        pessoa.setTrabalhos(pessoaDTO.getTrabalhos().stream().map(trabalhoDTO -> Trabalho.builder()
                .id(trabalhoDTO.getId())
                .nome(trabalhoDTO.getNome())
                .build()).toList());
        var response = pessoaRepository.save(pessoa);
        return response.toDto();
    }

    public void deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
