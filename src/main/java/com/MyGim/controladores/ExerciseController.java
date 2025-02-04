package com.MyGim.controladores;

import com.MyGim.entidades.Exercise;
import com.MyGim.entidades.Imagen;
import com.MyGim.enums.MuscleGroup;
import com.MyGim.servicios.ExerciseService;
import com.MyGim.servicios.ImagenServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private ImagenServicio imagenServicio;

 // Método para listar todos los ejercicios
 @GetMapping("/exercise/lista")
    public String getExerciseList(@RequestParam(name = "muscleGroup", required = false) MuscleGroup muscleGroup, Model model) {
        List<Exercise> exercises;
        if (muscleGroup != null) {
            exercises = exerciseService.findExercisesByMuscleGroup(muscleGroup);
        } else {
            exercises = exerciseService.findAllExercises();
        }
        model.addAttribute("exercises", exercises);
        model.addAttribute("muscleGroups", MuscleGroup.values());
        model.addAttribute("selectedMuscleGroup", muscleGroup);  // Añadir grupo muscular seleccionado
        return "exercise-lista";
    }

    // Método para mostrar el formulario de nuevo ejercicio
    @GetMapping("/ejercicios/nuevo")
    public String cargarFormularioEjercicio(Model model) {
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("muscleGroups", MuscleGroup.values());
        return "formulario-ejercicio";
    }

    // Método para guardar un nuevo ejercicio
    @PostMapping("/ejercicios/nuevo")
    public String guardarEjercicio(@Valid @ModelAttribute("exercise") Exercise exercise,
                                   BindingResult bindingResult,
                                   @RequestParam List<String> muscleGroups,
                                   @RequestParam("image") MultipartFile imageFile,
                                   Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("muscleGroups", MuscleGroup.values());
            return "formulario-ejercicio";
        }

        // Asignar los grupos musculares al ejercicio antes de guardar
        Set<MuscleGroup> muscleGroupSet = new HashSet<>();
        for (String muscleGroup : muscleGroups) {
            muscleGroupSet.add(MuscleGroup.valueOf(muscleGroup));
        }
        exercise.setMuscleGroups(muscleGroupSet);

        try {
            exerciseService.saveExercise(exercise, imageFile);
            return "redirect:/exercise/lista";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("muscleGroups", MuscleGroup.values());
            return "formulario-ejercicio";
        }
    }

    // Ruta para la administración de ejercicios (ABM)
    @GetMapping("/ejercicios/abm")
    public String listarEjercicios(Model model) {
        List<Exercise> exercises = exerciseService.findAllExercises();
        model.addAttribute("exercises", exercises);
        return "abm-ejercicios";
    }

    // Método para mostrar el formulario de modificación de ejercicios
    @GetMapping("/ejercicios/modificar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
        Exercise exercise = exerciseService.findById(id);
        if (exercise == null) {
            return "redirect:/ejercicios/abm";
        }
        model.addAttribute("exercise", exercise);
        model.addAttribute("muscleGroups", MuscleGroup.values());
        return "formulario-modificar-ejercicio";
    }

    // Método para procesar la modificación de un ejercicio
    @PostMapping("/ejercicios/modificar/{id}")
    public String procesarFormularioEdicion(@PathVariable("id") Long id,
                                            @Valid @ModelAttribute("exercise") Exercise exercise,
                                            BindingResult bindingResult,
                                            @RequestParam List<String> muscleGroups,
                                            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("muscleGroups", MuscleGroup.values());
            return "formulario-modificar-ejercicio";
        }

        // Asignar los grupos musculares al ejercicio antes de actualizar
        Set<MuscleGroup> muscleGroupSet = new HashSet<>();
        for (String muscleGroup : muscleGroups) {
            muscleGroupSet.add(MuscleGroup.valueOf(muscleGroup));
        }
        exercise.setMuscleGroups(muscleGroupSet);

        try {
            exerciseService.modifyExercise(id, exercise, null, muscleGroupSet);
            return "redirect:/ejercicios/abm";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("muscleGroups", MuscleGroup.values());
            return "formulario-modificar-ejercicio";
        }
    }

    @GetMapping("/ejercicios/eliminar/{id}")
    public String eliminarEjercicio(@PathVariable("id") Long id) {
        try {
            exerciseService.deleteExercise(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/ejercicios/abm";
    }



// Método para cambiar la imagen de un ejercicio
@PostMapping("/ejercicios/cambiar-imagen/{id}")
public String cambiarImagen(@PathVariable("id") Long id,
                            @RequestParam("image") MultipartFile imageFile,
                            Model model) {
    try {
        if (!imageFile.isEmpty()) {
            // Obtener el ejercicio actual
            Exercise exercise = exerciseService.findById(id);
            if (exercise == null) {
                throw new RuntimeException("Ejercicio no encontrado con ID: " + id);
            }

            // Actualizar la imagen
            Imagen nuevaImagen = imagenServicio.actualizar(imageFile, exercise.getImagen().getId());
            exerciseService.updateImage(id, nuevaImagen);
        }
        return "redirect:/ejercicios/abm";
    } catch (Exception e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", e.getMessage());
        return "redirect:/ejercicios/abm";
    }
}
}