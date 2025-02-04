package com.MyGim.controladores;

import com.MyGim.servicios.ExerciseCargaDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExerciseCargaDefaultController {

    @Autowired
    private ExerciseCargaDefault exerciseCargaDefault;

    @PostMapping("/cargarEjerciciosPredeterminados")
    @ResponseBody
    public String cargarEjerciciosPredeterminados() {
        try {
            exerciseCargaDefault.saveDefaultExercises();
            return "{\"message\": \"Ejercicios predeterminados cargados exitosamente.\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"message\": \"Ocurrió un error al cargar los ejercicios predeterminados.\"}";
        }
    }
}
