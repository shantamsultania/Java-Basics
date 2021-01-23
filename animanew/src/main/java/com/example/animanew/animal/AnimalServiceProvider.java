package com.example.animanew.animal;


import com.example.animanew.animal.model.Animal;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalServiceProvider {

    List<Animal> animalList ;

    AnimalServiceProvider() {
        animalList = new ArrayList<>();
    }

    public List<Animal> getAllAnimals() {
        animalList.add(new Animal("100","animal1", "male", "grass"));
        animalList.add(new Animal("101","animal2", "female", "water"));

        return animalList;
    }

    public Animal addAnimal(Animal animal) {
        animalList.add(animal);
        return animal;
    }

    public String updateAnimal(Animal animal) {
        int i = 0;
        for (Animal ani : animalList) {
            if (ani.getAnimalId() == null)
            {
                continue;
            }
            if (ani.getAnimalId().equals(animal.getAnimalId())) {
                animalList.set(i, animal);
                return "Animal Updated";
            } else {
                i++;
            }
        }
        return "no animal found";
    }

    public String deleteAnimal(Animal animal) {
        int i = 0;
        boolean flag = false;

        for (Animal ani : animalList) {
            if (ani.getAnimalId().equals(animal.getAnimalId())) {
                animalList.remove(i);
                flag = true;
            } else {
                i++;
            }
        }
        if (flag)
        return "Animal Deleted";
        else
        {
            return "Animal Not deleted";
        }
    }


}
