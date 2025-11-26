package com.finan.orcamento.controller;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String cadastraUsuario(@ModelAttribute UsuarioModel usuarioModel) {
        usuarioService.cadastrarUsuario(usuarioModel);
        return "redirect:/";
    }

    // Nova rota de excluir
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return "redirect:/";
    }
}