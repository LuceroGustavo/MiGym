package com.MyGim.controladores;

import com.MyGim.entidades.Usuario;
import com.MyGim.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/nuevo")
    public String showForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "nuevoUsuario";
    }

    @PostMapping
    public String createUsuario(@ModelAttribute Usuario usuario, Model model) {
        try {
            usuarioService.createUsuario(usuario);
            return "redirect:/usuarios";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "nuevoUsuario";
        }
    }
}
