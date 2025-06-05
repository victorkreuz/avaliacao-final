package com.example.avaliacao.service;

import com.example.avaliacao.entity.Cripto;
import com.example.avaliacao.repository.CriptoRepository;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service

public class CriptoService {

    @Autowired
    CriptoRepository criptoRepository;


    public Cripto salvar(Cripto cripto) {
        return criptoRepository.save(cripto);
    }

    public Optional<Cripto> buscarCriptoPorId(Long id) {
        return criptoRepository.findById(id);

    }

    public List<Cripto> buscarCripto() {
        return criptoRepository.findAll();
    }

    public Cripto editar(Cripto cripto) {

        return criptoRepository.save(cripto);
    }

    public void excluir(Long id) {
        criptoRepository.deleteById(id);
    }

    public String converterCriptoParaReal(Cripto moeda, Double valor) {
        String valorMoeda = moeda.getPrecoAtual();
        Double valorConvertido = Double.parseDouble(valorMoeda) * valor;
        return valorConvertido.toString();
    }
}
