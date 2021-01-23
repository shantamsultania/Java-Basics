package com.example.animanew.animal.model;


import io.github.biezhi.anima.annotation.Column;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;

@Table(name = "animal", pk = "animal_id")
@Data
public class Animal {

    @Column(name = "animal_id")
    String animalId;

    @Column(name = "animal_name")
    String animalName;

    @Column(name = "animal_gender")
    String animalGender;

    @Column(name = "animal_type")
    String animalType;


    public Animal(String animalId, String animalName, String animalGender, String animalType) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalGender = animalGender;
        this.animalType = animalType;
    }


}
