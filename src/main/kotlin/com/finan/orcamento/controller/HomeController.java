package com.finan.orcamento.controller;

import com.finan.orcamento.model.ClienteModel;
import com.finan.orcamento.model.OrcamentoModel;
import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.repositories.OrcamentoRepository;
import com.finan.orcamento.service.ClienteService;
import com.finan.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") 
public class HomeController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("clienteModel", new ClienteModel());
        model.addAttribute("usuarioModel", new UsuarioModel());
        
        OrcamentoModel orcamento = new OrcamentoModel();
        orcamento.setCliente(new ClienteModel());
        orcamento.setUsuario(new UsuarioModel());
        model.addAttribute("orcamentoModel", orcamento);

        model.addAttribute("clientes", clienteService.buscarTodos());
        model.addAttribute("usuarios", usuarioService.buscarUsuario());
        model.addAttribute("orcamentos", orcamentoRepository.findAll());

        return "home"; 
    }
}