package com.finan.orcamento.service;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarUsuario(){
        return usuarioRepository.findAll();
    }

    // Método usado pelo Modal de Pesquisa
    public List<UsuarioModel> buscarUsuariosPorNome(String termo) {
        return usuarioRepository.findByNomeUsuarioContainingIgnoreCase(termo);
    }

    public UsuarioModel cadastrarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }
    
    // ... outros métodos (buscaId, delete, etc) se precisar
}