package com.bonam.prova.domain.service;

import com.bonam.prova.domain.dto.TrabalhoDTO;
import com.bonam.prova.domain.model.Trabalho;
import com.bonam.prova.domain.repository.TrabalhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabalhoService {

    private final TrabalhoRepository trabalhoRepository;

    public List<TrabalhoDTO> getAllTrabalhos() {
        var response = trabalhoRepository.findAll();
        return response.stream().map(Trabalho::toDto).toList();
    }

    public TrabalhoDTO getTrabalhoById(Long id) {
        var trabalho = trabalhoRepository.findById(id).orElseThrow();
        return trabalho.toDto();
    }

    public TrabalhoDTO saveTrabalho(TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = Trabalho.builder()
                .nome(trabalhoDTO.getNome())
                .build();
        var response = trabalhoRepository.save(trabalho);
        return response.toDto();
    }

    public TrabalhoDTO updateTrabalho(Long id, TrabalhoDTO trabalhoDTO) {
        Trabalho trabalho = trabalhoRepository.findById(id).orElseThrow();
        trabalho.setNome(trabalhoDTO.getNome());
        var response = trabalhoRepository.save(trabalho);
        return response.toDto();
    }

    public void deleteTrabalho(Long id) {
        trabalhoRepository.deleteById(id);
    }
}
