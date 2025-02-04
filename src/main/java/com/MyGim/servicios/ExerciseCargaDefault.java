package com.MyGim.servicios;

import com.MyGim.entidades.Exercise;
import com.MyGim.enums.MuscleGroup;
import com.MyGim.repositorios.ExerciseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ExerciseCargaDefault {

    private final ExerciseService exerciseService;

    public ExerciseCargaDefault(ExerciseRepository exerciseRepository, ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @Transactional
    public void saveDefaultExercises() {
        List<Exercise> defaultExercises = new ArrayList<>();
        
        // Ejercicios para BRAZOS
        defaultExercises.add(new Exercise("Curl de Bíceps con Barra", "Mejora la fuerza de los bíceps", Set.of(MuscleGroup.BRAZOS), "Ejercicio para bíceps", "http://example.com/video1", "Realizar 3 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Extensiones de Tríceps", "Desarrolla los tríceps", Set.of(MuscleGroup.BRAZOS), "Ejercicio para tríceps", "http://example.com/video2", "Hacer 3 series de 15 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Curl de Martillo", "Trabaja los bíceps y los antebrazos", Set.of(MuscleGroup.BRAZOS), "Ejercicio para bíceps", "http://example.com/video3", "Hacer 3 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Fondos", "Desarrolla los tríceps y el pecho", Set.of(MuscleGroup.BRAZOS), "Ejercicio para tríceps y pecho", "http://example.com/video4", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Curl de Bíceps con Mancuernas", "Aísla los bíceps", Set.of(MuscleGroup.BRAZOS), "Ejercicio para bíceps", "http://example.com/video5", "Hacer 3 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Press Francés", "Fortalece los tríceps", Set.of(MuscleGroup.BRAZOS), "Ejercicio para tríceps", "http://example.com/video6", "Realizar 3 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Curl de Bíceps en Predicador", "Aísla los bíceps", Set.of(MuscleGroup.BRAZOS), "Ejercicio para bíceps", "http://example.com/video7", "Hacer 3 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Patada de Tríceps", "Aísla los tríceps", Set.of(MuscleGroup.BRAZOS), "Ejercicio para tríceps", "http://example.com/video8", "Realizar 3 series de 15 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Curl de Bíceps con Cable", "Aísla los bíceps", Set.of(MuscleGroup.BRAZOS), "Ejercicio para bíceps", "http://example.com/video9", "Hacer 3 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Press de Tríceps en Máquina", "Fortalece los tríceps", Set.of(MuscleGroup.BRAZOS), "Ejercicio para tríceps", "http://example.com/video10", "Realizar 3 series de 15 repeticiones", "", ""));
        
        // Ejercicios para PIERNAS
        defaultExercises.add(new Exercise("Sentadillas con Barra", "Fortalece los cuádriceps", Set.of(MuscleGroup.PIERNAS), "Ejercicio para cuádriceps", "http://example.com/video11", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Elevación de Caderas", "Desarrolla los glúteos", Set.of(MuscleGroup.PIERNAS), "Ejercicio para glúteos", "http://example.com/video12", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Peso Muerto", "Trabaja los isquiotibiales y glúteos", Set.of(MuscleGroup.PIERNAS), "Ejercicio para isquiotibiales y glúteos", "http://example.com/video13", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Prensa de Piernas", "Fortalece los cuádriceps", Set.of(MuscleGroup.PIERNAS), "Ejercicio para cuádriceps", "http://example.com/video14", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Desplantes", "Desarrolla los cuádriceps y glúteos", Set.of(MuscleGroup.PIERNAS), "Ejercicio para cuádriceps y glúteos", "http://example.com/video15", "Realizar 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Elevación de Talones", "Fortalece los gemelos", Set.of(MuscleGroup.PIERNAS), "Ejercicio para gemelos", "http://example.com/video16", "Hacer 4 series de 15 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Zancadas con Barra", "Trabaja los cuádriceps y glúteos", Set.of(MuscleGroup.PIERNAS), "Ejercicio para cuádriceps y glúteos", "http://example.com/video17", "Realizar 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Curl de Piernas en Máquina", "Aísla los isquiotibiales", Set.of(MuscleGroup.PIERNAS), "Ejercicio para isquiotibiales", "http://example.com/video18", "Hacer 4 series de 15 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Sentadillas Búlgaras", "Desarrolla los cuádriceps y glúteos", Set.of(MuscleGroup.PIERNAS), "Ejercicio para cuádriceps y glúteos", "http://example.com/video19", "Realizar 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Elevación de Talones en Máquina", "Fortalece los gemelos", Set.of(MuscleGroup.PIERNAS), "Ejercicio para gemelos", "http://example.com/video20", "Hacer 4 series de 15 repeticiones", "", ""));

        // Ejercicios para PECHO
        defaultExercises.add(new Exercise("Press de Banca", "Desarrolla la masa muscular del pecho", Set.of(MuscleGroup.PECHO), "Ejercicio para el pecho", "http://example.com/video21", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Press de Banca Inclinado", "Fortalece el pecho y tríceps", Set.of(MuscleGroup.PECHO), "Ejercicio para el pecho", "http://example.com/video22", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Aperturas con Mancuernas", "Aísla el pecho", Set.of(MuscleGroup.PECHO), "Ejercicio para el pecho", "http://example.com/video23", "Realizar 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Fondos en Paralelas", "Trabaja el pecho y tríceps", Set.of(MuscleGroup.PECHO), "Ejercicio para pecho y tríceps", "http://example.com/video24", "Hacer 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Press de Banca Declinado", "Fortalece la parte baja del pecho", Set.of(MuscleGroup.PECHO), "Ejercicio para el pecho", "http://example.com/video25", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Press de Banca con Mancuernas", "Desarrolla el pecho y los tríceps", Set.of(MuscleGroup.PECHO), "Ejercicio para el pecho", "http://example.com/video26", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Aperturas en Máquina", "Aísla el pecho", Set.of(MuscleGroup.PECHO), "Ejercicio para el pecho", "http://example.com/video27", "Realizar 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Press de Banca con Mancuernas Inclinado", "Fortalece el pecho y tríceps", Set.of(MuscleGroup.PECHO), "Ejercicio para el pecho", "http://example.com/video28", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Flexiones", "Trabaja el pecho y tríceps", Set.of(MuscleGroup.PECHO), "Ejercicio para pecho y tríceps", "http://example.com/video29", "Realizar 4 series de 15 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Cruce de Poleas", "Aísla el pecho", Set.of(MuscleGroup.PECHO), "Ejercicio para el pecho", "http://example.com/video30", "Hacer 4 series de 12 repeticiones", "", ""));

        // Ejercicios para ESPALDA
        defaultExercises.add(new Exercise("Dominadas", "Fortalece la parte superior de la espalda", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda", "http://example.com/video31", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Jalón al Pecho", "Desarrolla los dorsales", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda", "http://example.com/video32", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Remo con Barra", "Fortalece los dorsales y trapecios", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda", "http://example.com/video33", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Remo con Mancuernas", "Desarrolla la espalda media y baja", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda", "http://example.com/video34", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Pullover con Mancuerna", "Fortalece los dorsales y pectorales", Set.of(MuscleGroup.ESPALDA), "Ejercicio para dorsales y pectorales", "http://example.com/video35", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Remo en Máquina", "Aísla los dorsales", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda", "http://example.com/video36", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Pull-Up Asistido", "Fortalece la parte superior de la espalda", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda", "http://example.com/video37", "Realizar 4 series de 10 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Jalón al Pecho en Máquina", "Desarrolla los dorsales", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda", "http://example.com/video38", "Hacer 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Remo en Polea Baja", "Fortalece la espalda media y baja", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda", "http://example.com/video39", "Realizar 4 series de 12 repeticiones", "", ""));
        defaultExercises.add(new Exercise("Peso Muerto Sumo", "Desarrolla la espalda baja y glúteos", Set.of(MuscleGroup.ESPALDA), "Ejercicio para la espalda y glúteos", "http://example.com/video40", "Hacer 4 series de 10 repeticiones", "", ""));

        // Ejercicios para CARDIO
        defaultExercises.add(new Exercise("Cinta de Correr", "Mejora la resistencia cardiovascular", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video41", "Realizar 30 minutos a ritmo moderado", "", ""));
        defaultExercises.add(new Exercise("Bicicleta Estática", "Desarrolla la resistencia cardiovascular", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video42", "Hacer 30 minutos a ritmo intenso", "", ""));
        defaultExercises.add(new Exercise("Elíptica", "Mejora la resistencia cardiovascular y tonifica", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video43", "Realizar 30 minutos a ritmo moderado", "", ""));
        defaultExercises.add(new Exercise("Remo", "Fortalece el sistema cardiovascular y muscular", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video44", "Hacer 20 minutos a ritmo intenso", "", ""));
        defaultExercises.add(new Exercise("Salto de Cuerda", "Desarrolla la resistencia y coordinación", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video45", "Realizar 15 minutos de saltos continuos", "", ""));
        defaultExercises.add(new Exercise("Clases de Aeróbicos", "Mejora la resistencia cardiovascular", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video46", "Hacer 45 minutos de clase", "", ""));
        defaultExercises.add(new Exercise("Stepper", "Fortalece el sistema cardiovascular y muscular", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video47", "Realizar 30 minutos a ritmo moderado", "", ""));
        defaultExercises.add(new Exercise("Natación", "Mejora la resistencia cardiovascular y tonifica", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video48", "Nadar 30 minutos a ritmo moderado", "", ""));
        defaultExercises.add(new Exercise("Ciclismo", "Desarrolla la resistencia y fortalece las piernas", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video49", "Realizar 60 minutos a ritmo moderado", "", ""));
        defaultExercises.add(new Exercise("Subir Escaleras", "Fortalece el sistema cardiovascular y muscular", Set.of(MuscleGroup.CARDIO), "Ejercicio para cardio", "http://example.com/video50", "Subir y bajar escaleras durante 20 minutos", "", ""));

        // Ejercicios para ELONGACION
        defaultExercises.add(new Exercise("Estiramiento de Cuádriceps", "Aumenta la flexibilidad en los cuádriceps", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video51", "Realizar 3 series de 30 segundos por pierna", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Isquiotibiales", "Desarrolla la flexibilidad en los isquiotibiales", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video52", "Hacer 3 series de 30 segundos por pierna", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Cadera", "Aumenta la flexibilidad en la cadera", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video53", "Realizar 3 series de 30 segundos por pierna", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Hombros", "Desarrolla la flexibilidad en los hombros", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video54", "Hacer 3 series de 30 segundos por brazo", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Cuello", "Aumenta la flexibilidad en el cuello", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video55", "Realizar 3 series de 30 segundos", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Espalda Baja", "Desarrolla la flexibilidad en la espalda baja", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video56", "Hacer 3 series de 30 segundos", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Pecho", "Aumenta la flexibilidad en el pecho", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video57", "Realizar 3 series de 30 segundos", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Pantorrillas", "Desarrolla la flexibilidad en las pantorrillas", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video58", "Hacer 3 series de 30 segundos por pierna", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Cuádriceps en Pareja", "Aumenta la flexibilidad en los cuádriceps", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video59", "Realizar 3 series de 30 segundos por pierna", "", ""));
        defaultExercises.add(new Exercise("Estiramiento de Isquiotibiales en Pareja", "Desarrolla la flexibilidad en los isquiotibiales", Set.of(MuscleGroup.ELONGACION), "Ejercicio de elongación", "http://example.com/video60", "Hacer 3 series de 30 segundos por pierna", "", ""));

        for (Exercise exercise : defaultExercises) {
            try {
                exerciseService.saveExercise(exercise, null); // Usar null para indicar que no hay imagen proporcionada
            } catch (Exception e) {
                System.err.println("Error al guardar el ejercicio: " + exercise.getName() + ". " + e.getMessage());
            }
        }
    }
}
