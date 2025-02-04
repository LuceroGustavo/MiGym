package com.MyGim.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Set;
import com.MyGim.enums.MuscleGroup;
@Data
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ElementCollection
    private Set<MuscleGroup> muscleGroups;

    private String type;
    private String videoUrl;
    private String instructions;
    private String benefits;
    private String contraindications;

    @OneToOne(cascade = CascadeType.ALL)
    private Imagen imagen;

    // Constructor sin argumentos
    public Exercise() {}

    // Constructor con argumentos
    public Exercise(String name, String description, Set<MuscleGroup> muscleGroups, String type,
                    String videoUrl, String instructions, String benefits, String contraindications) {
        this.name = name;
        this.description = description;
        this.muscleGroups = muscleGroups;
        this.type = type;
        this.videoUrl = videoUrl;
        this.instructions = instructions;
        this.benefits = benefits;
        this.contraindications = contraindications;
    }

}
