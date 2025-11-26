package com.finan.orcamento.repositories;

import com.finan.orcamento.model.OrcamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrcamentoModel, Long> {
    
    // Busca no banco onde a data está entre inicio e fim
    List<OrcamentoModel> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);

    // Busca no banco onde o valor está entre min e max
    List<OrcamentoModel> findByValorBetween(BigDecimal valorMin, BigDecimal valorMax);
}