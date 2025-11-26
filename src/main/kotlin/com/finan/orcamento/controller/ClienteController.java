package com.finan.orcamento.controller;

import com.finan.orcamento.model.ClienteModel;
import com.finan.orcamento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ClienteModel clienteModel) {
        clienteService.salvar(clienteModel);
        return "redirect:/";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return "redirect:/";
    }
}