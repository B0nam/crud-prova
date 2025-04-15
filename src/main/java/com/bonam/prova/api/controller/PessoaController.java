package com.bonam.prova.api.controller;

import com.bonam.prova.domain.dto.PessoaDTO;
import com.bonam.prova.domain.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping()
    public ResponseEntity<List<PessoaDTO>> getPessoas() {
        return ResponseEntity.ok(pessoaService.getAllPessoas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> getPessoaById(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.getPessoaById(id));
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> savePessoa(@RequestBody PessoaDTO pessoaDTO) {
        return ResponseEntity.ok(pessoaService.savePessoa(pessoaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> updatePessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        var response = pessoaService.updatePessoa(id, pessoaDTO);
        return ResponseEntity.ok(response);
    }
}
