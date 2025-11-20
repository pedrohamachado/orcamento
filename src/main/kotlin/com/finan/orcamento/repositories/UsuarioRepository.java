package com.finan.orcamento.repositories;

import com.finan.orcamento.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    // Busca usuários onde o nome CONTÉM o texto (ignorando maiúsculas/minúsculas)
    List<UsuarioModel> findByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}