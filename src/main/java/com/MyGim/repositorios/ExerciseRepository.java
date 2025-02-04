package com.MyGim.repositorios;

import com.MyGim.entidades.Exercise;
import com.MyGim.enums.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Optional<Exercise> findByName(String name);
    List<Exercise> findByMuscleGroups(MuscleGroup muscleGroup);
}
