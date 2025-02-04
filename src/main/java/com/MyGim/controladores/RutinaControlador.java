package com.MyGim.controladores;

import com.MyGim.entidades.Exercise;
import com.MyGim.entidades.Rutina;
import com.MyGim.entidades.Usuario;
import com.MyGim.servicios.ExerciseService;
import com.MyGim.servicios.RutinaService;
import com.MyGim.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rutinas")
public class RutinaControlador {

    @Autowired
    private RutinaService rutinaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping
    public String listRutinas(Model model) {
        List<Rutina> rutinas = rutinaService.getAllRutinas();
        model.addAttribute("rutinas", rutinas);
        return "rutinas";
    }

    @GetMapping("/nueva")
    public String showForm(Model model) {
        model.addAttribute("rutina", new Rutina());
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        model.addAttribute("usuarios", usuarios);
        List<Exercise> exercises = exerciseService.findAllExercises();
        model.addAttribute("exercises", exercises);
        return "exercise-lista"; // Redirige al HTML del carrusel
    }

    @PostMapping
    public String createRutina(@ModelAttribute Rutina rutina, @RequestParam Long usuarioId, Model model) {
        try {
            rutinaService.createRutina(rutina, usuarioId);
            return "redirect:/rutinas";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            List<Usuario> usuarios = usuarioService.getAllUsuarios();
            model.addAttribute("usuarios", usuarios);
            List<Exercise> exercises = exerciseService.findAllExercises();
            model.addAttribute("exercises", exercises);
            return "exercise-lista"; // Redirige al HTML del carrusel
        }
    }
}
