package com.finan.orcamento.controller;

import com.finan.orcamento.model.UsuarioModel;
import com.finan.orcamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String getUsuarioPage(Model model) {
        model.addAttribute("usuarioModel", new UsuarioModel());
        // Carrega a lista de usuários para a tabela
        model.addAttribute("usuarios", usuarioService.buscarUsuario());
        return "usuarioPage";
    }

    @PostMapping
    public String cadastraUsuario(@ModelAttribute UsuarioModel usuarioModel) {
        usuarioService.cadastrarUsuario(usuarioModel);
        return "redirect:/usuarios/pesquisa";
    }

    @GetMapping("/pesquisa")
    public String listarUsuarios(Model model) {
        List<UsuarioModel> usuarios = usuarioService.buscarUsuario();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuarioModel", new UsuarioModel());
        return "usuarioPage";
    }
}