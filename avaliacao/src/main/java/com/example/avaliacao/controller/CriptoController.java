package com.example.avaliacao.controller;

import com.example.avaliacao.entity.Cripto;
import com.example.avaliacao.repository.CriptoRepository;
import com.example.avaliacao.service.CriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cripto")

public class CriptoController {

    @Autowired

    private CriptoService criptoService;
    @Autowired
    private CriptoRepository criptoRepository;

    @PostMapping
    public Cripto salvarCripto(@RequestBody Cripto cripto) {
        return criptoService.salvar(cripto);
    }

    @GetMapping("{id}")
    public Cripto buscarCriptoPorId(@PathVariable Long id) {
        return criptoService.buscarCriptoPorId(id).get();
    }

    @GetMapping
    public List<Cripto> ListarCripto() {
        return criptoService.buscarCripto();
    }

    @PutMapping("{id}")
    public String atualizar(@PathVariable Long id, @RequestBody Cripto cripto) {
        Optional<Cripto> criptoAtual = criptoService.buscarCriptoPorId(id);
        if (criptoAtual.isEmpty()) {
            return "Cripto com " + id + " não encontrado. ";
        }
        cripto.setId((criptoAtual.get().getId()));
        criptoService.editar(cripto);
        return "Cripto atualizada com sucesso!";
    }

    @DeleteMapping("{id}")
    public String excluirCripto(@PathVariable Long id) {
        criptoService.excluir(id);
        return "Cripto excluida com sucesso!";
    }

    @PutMapping("/converte/{moeda}/{valor}")
    public String converterCripto(@PathVariable String moeda, @PathVariable Double valor) {
        Cripto moedaPorSigla = criptoRepository.findBySigla(moeda);
        HashMap conversao = new HashMap<String, Double>();
        conversao.put(moeda, valor);
        conversao.put("R$", criptoService.converterCriptoParaReal(moedaPorSigla, valor));
        return conversao.toString();
    }

}
