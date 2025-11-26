package com.finan.orcamento.controller;

import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.model.ClienteModel;
import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.service.ClienteService;
import com.finan.orcamento.service.UsuarioService;
import com.finan.orcamento.repositories.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentoController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    // API para buscar CLIENTES (Usada pelo JavaScript)
    @GetMapping("/pesquisar-cliente")
    @ResponseBody
    public List<ClienteModel> pesquisarClientes(@RequestParam("termo") String termo) {
        return clienteService.pesquisar(termo);
    }

    // API para buscar USUÁRIOS (Usada pelo JavaScript)
    @GetMapping("/pesquisar-usuario")
    @ResponseBody
    public List<UsuarioModel> pesquisarUsuarios(@RequestParam("termo") String termo) {
        return usuarioService.buscarUsuariosPorNome(termo);
    }

    @PostMapping("/salvar")
    public String salvarOrcamento(OrcamentoModel orcamento) {
        if (orcamento.getCliente() == null || orcamento.getCliente().getId() == null) {
            orcamento.setCliente(null);
        }
        if (orcamento.getUsuario() == null || orcamento.getUsuario().getId() == null) {
            orcamento.setUsuario(null);
        }

        orcamentoRepository.save(orcamento);
        return "redirect:/"; // Volta para a página única
    }
}