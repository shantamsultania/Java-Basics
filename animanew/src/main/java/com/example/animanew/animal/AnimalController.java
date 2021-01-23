package com.example.animanew.animal;

import com.example.animanew.animal.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {


    final
    AnimalServiceProvider animalServiceProvider;


    public AnimalController(AnimalServiceProvider animalServiceProvider) {
        this.animalServiceProvider = animalServiceProvider;
    }

    @GetMapping("/getanimal")
    public ResponseEntity<List<Animal>> getAnimal() {
        List<Animal> animalList = animalServiceProvider.getAllAnimals();
        return new ResponseEntity<>(animalList, HttpStatus.OK);
    }

    @PostMapping("/addanimal")
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal ani)
    {
        Animal animal = animalServiceProvider.addAnimal(ani);
        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @PutMapping("/updateanimal")
    public ResponseEntity<String> updateAnimal(@RequestBody Animal ani)
    {
        String Result = animalServiceProvider.updateAnimal(ani);
        return new ResponseEntity<>(Result, HttpStatus.OK);
    }

    @DeleteMapping("/deleteanimal")
    public ResponseEntity<String> deleteAnimal(@RequestBody Animal ani)
    {
        String Result = animalServiceProvider.deleteAnimal(ani);
        return new ResponseEntity<>(Result, HttpStatus.OK);
    }




}
