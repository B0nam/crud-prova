package com.bonam.prova.domain.repository;

import com.bonam.prova.domain.model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
}
