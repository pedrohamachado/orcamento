package com.finan.orcamento.controller;

import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.repositories.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @GetMapping("/por-data")
    public List<OrcamentoModel> buscaPorData(
            @RequestParam("inicio") LocalDate inicio, 
            @RequestParam("fim") LocalDate fim) {
        return orcamentoRepository.findByDataBetween(inicio, fim);
    }

    @GetMapping("/por-valor")
    public List<OrcamentoModel> buscaPorValor(
            @RequestParam("min") BigDecimal min, 
            @RequestParam("max") BigDecimal max) {
        return orcamentoRepository.findByValorBetween(min, max);
    }
}