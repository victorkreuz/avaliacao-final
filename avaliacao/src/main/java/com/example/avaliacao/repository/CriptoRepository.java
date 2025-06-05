package com.example.avaliacao.repository;

import com.example.avaliacao.entity.Cripto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriptoRepository extends JpaRepository<Cripto, Long> {
    public Cripto findBySigla(String codigo);
}