package com.finan.orcamento.service;

import com.finan.orcamento.model.ClienteModel;
import com.finan.orcamento.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService { // <--- O erro diz que essa linha estava faltando ou errada

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteModel> buscarTodos() {
        return clienteRepository.findAll();
    }

    public ClienteModel salvar(ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }
    
    public List<ClienteModel> pesquisar(String termo) {
        return clienteRepository.findByNomeContainingIgnoreCase(termo);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
    
    public ClienteModel buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}