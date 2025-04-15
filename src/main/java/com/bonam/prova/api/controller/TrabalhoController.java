package com.bonam.prova.api.controller;

import com.bonam.prova.domain.dto.TrabalhoDTO;
import com.bonam.prova.domain.service.TrabalhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/trabalhos")
@RequiredArgsConstructor
public class TrabalhoController {

    private final TrabalhoService trabalhoService;

    @GetMapping()
    public ResponseEntity<List<TrabalhoDTO>> getTrabalhos() {
        return ResponseEntity.ok(trabalhoService.getAllTrabalhos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> getTrabalhoById(@PathVariable Long id) {
        return ResponseEntity.ok(trabalhoService.getTrabalhoById(id));
    }

    @PostMapping
    public ResponseEntity<TrabalhoDTO> saveTrabalho(@RequestBody TrabalhoDTO trabalhoDTO) {
        return ResponseEntity.ok(trabalhoService.saveTrabalho(trabalhoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrabalho(@PathVariable Long id) {
        trabalhoService.deleteTrabalho(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> updateTrabalho(@PathVariable Long id, @RequestBody TrabalhoDTO trabalhoDTO) {
        var response = trabalhoService.updateTrabalho(id, trabalhoDTO);
        return ResponseEntity.ok(response);
    }
}
