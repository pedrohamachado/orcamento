package com.finan.orcamento.controller;

import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.model.ClienteModel;
import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.service.ClienteService;
import com.finan.orcamento.service.UsuarioService;
import com.finan.orcamento.repositories.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orcamentos")
public class OrcamentoController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService; // Agora usamos o serviço de usuário também

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @GetMapping
    public String abrirPaginaOrcamentos(Model model) {
        OrcamentoModel orcamento = new OrcamentoModel();
        
        // Inicializa ambos vazios para não dar erro no HTML
        orcamento.setCliente(new ClienteModel());
        orcamento.setUsuario(new UsuarioModel());
        
        model.addAttribute("orcamentoModel", orcamento);
        model.addAttribute("orcamentos", orcamentoRepository.findAll());
        return "orcamentoPage";
    }

    // API para buscar CLIENTES
    @GetMapping("/pesquisar-cliente")
    @ResponseBody
    public List<ClienteModel> pesquisarClientes(@RequestParam("termo") String termo) {
        return clienteService.pesquisar(termo);
    }

    // API para buscar USUÁRIOS
    @GetMapping("/pesquisar-usuario")
    @ResponseBody
    public List<UsuarioModel> pesquisarUsuarios(@RequestParam("termo") String termo) {
        return usuarioService.buscarUsuariosPorNome(termo);
    }

    @PostMapping("/salvar")
    public String salvarOrcamento(OrcamentoModel orcamento) {
        // Limpeza: Se o ID vier nulo/zero, definimos o objeto como null
        // Isso garante que salve APENAS um dos dois (ou Cliente ou Usuario)
        if (orcamento.getCliente() == null || orcamento.getCliente().getId() == null) {
            orcamento.setCliente(null);
        }
        if (orcamento.getUsuario() == null || orcamento.getUsuario().getId() == null) {
            orcamento.setUsuario(null);
        }

        orcamentoRepository.save(orcamento);
        return "redirect:/orcamentos";
    }
}