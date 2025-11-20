package com.finan.orcamento.controller;

import com.finan.orcamento.model.ClienteModel;
import com.finan.orcamento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String paginaClientes(Model model) {
        model.addAttribute("clienteModel", new ClienteModel());
        model.addAttribute("clientes", clienteService.buscarTodos());
        return "clientePage"; // Vamos criar esse HTML
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ClienteModel clienteModel) {
        clienteService.salvar(clienteModel);
        return "redirect:/clientes";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return "redirect:/clientes";
    }
    
    // Para editar, carregamos os dados no formulário
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("clienteModel", clienteService.buscarPorId(id));
        model.addAttribute("clientes", clienteService.buscarTodos());
        return "clientePage";
    }
}