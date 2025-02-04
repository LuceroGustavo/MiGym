package com.MyGim.servicios;

import com.MyGim.entidades.Exercise;
import com.MyGim.entidades.Imagen;
import com.MyGim.enums.MuscleGroup;
import com.MyGim.repositorios.ExerciseRepository;
import com.MyGim.repositorios.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private ImagenServicio imagenServicio;

    public List<Exercise> findAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise findById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public List<Exercise> findExercisesByMuscleGroup(MuscleGroup muscleGroup) {
        return exerciseRepository.findByMuscleGroups(muscleGroup);
    }

    @Transactional
    public void saveExercise(Exercise exercise, MultipartFile imageFile) throws Exception {
        Optional<Exercise> existingExercise = exerciseRepository.findByName(exercise.getName());
        if (existingExercise.isPresent()) {
            throw new Exception("Exercise with the same name already exists");
        }

        if (imageFile != null && !imageFile.isEmpty()) {
            Imagen imagen = imagenServicio.guardar(imageFile);
            exercise.setImagen(imagen);
        } else {
            try {
                Path defaultImagePath = Paths.get("src/main/resources/static/img/not_imagen.png");
                byte[] defaultImageBytes = Files.readAllBytes(defaultImagePath);
                Imagen defaultImagen = imagenServicio.guardar(defaultImageBytes, "not_imagen.png");
                exercise.setImagen(defaultImagen);
            } catch (IOException e) {
                throw new RuntimeException("Error al leer la imagen predeterminada", e);
            }
        }

        exerciseRepository.save(exercise);
    }

    @Transactional
    public void modifyExercise(Long exerciseId, Exercise exerciseDetails, MultipartFile imageFile, Set<MuscleGroup> muscleGroups) throws Exception {
        Exercise exercise = exerciseRepository.findById(exerciseId)
                .orElseThrow(() -> new Exception("Exercise not found"));

        if (!exercise.getName().equals(exerciseDetails.getName()) &&
                exerciseRepository.findByName(exerciseDetails.getName()).isPresent()) {
            throw new Exception("Exercise with the same name already exists");
        }

        exercise.setName(exerciseDetails.getName());
        exercise.setDescription(exerciseDetails.getDescription());
        exercise.setType(exerciseDetails.getType());
        exercise.setVideoUrl(exerciseDetails.getVideoUrl());
        exercise.setInstructions(exerciseDetails.getInstructions());
        exercise.setBenefits(exerciseDetails.getBenefits());
        exercise.setContraindications(exerciseDetails.getContraindications());
        exercise.setMuscleGroups(muscleGroups);

        if (imageFile != null && !imageFile.isEmpty()) {
            Imagen newImagen = imagenServicio.guardar(imageFile);
            if (exercise.getImagen() != null) {
                imagenRepository.delete(exercise.getImagen());
            }
            exercise.setImagen(newImagen);
        }

        exerciseRepository.save(exercise);
    }

    @Transactional
    public void deleteExercise(Long id) {
        Optional<Exercise> exerciseOpt = exerciseRepository.findById(id);
        if (exerciseOpt.isPresent()) {
            Exercise exercise = exerciseOpt.get();
            if (exercise.getImagen() != null) {
                Imagen imagen = exercise.getImagen();
                if (!"not_imagen.png".equals(imagen.getNombre())) {
                    imagenRepository.delete(imagen);
                }
            }
            exerciseRepository.deleteById(id);
        }
    }

    public void updateImage(Long id, Imagen nuevaImagen) {
        try {
            Exercise exercise = exerciseRepository.findById(id)
                    .orElseThrow(() -> new Exception("Ejercicio no encontrado con ID: " + id));
            exercise.setImagen(nuevaImagen);
            exerciseRepository.save(exercise);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la imagen del ejercicio con ID: " + id, e);
        }
    }
}
