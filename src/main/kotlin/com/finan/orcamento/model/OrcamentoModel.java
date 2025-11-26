package com.finan.orcamento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate; // Importação da data

@Entity
@Table(name = "orcamento")
public class OrcamentoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data_orcamento")
    private LocalDate data; // Novo campo Data

    // Relacionamento com CLIENTE
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    @JsonBackReference
    private ClienteModel cliente;

    // Relacionamento com USUARIO
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    @JsonBackReference
    private UsuarioModel usuario;

    public OrcamentoModel() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public ClienteModel getCliente() { return cliente; }
    public void setCliente(ClienteModel cliente) { this.cliente = cliente; }

    public UsuarioModel getUsuario() { return usuario; }
    public void setUsuario(UsuarioModel usuario) { this.usuario = usuario; }
}