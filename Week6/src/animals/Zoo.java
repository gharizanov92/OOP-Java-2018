package animals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zoo {
    // volatile means that this value would no be cached - read about Threads for more info
    private static volatile Zoo instance;
    private final List<Animal> animalKingdom;

    private Zoo() {
        animalKingdom = new ArrayList<>();
    }

    public static Zoo getInstance() {
        if (instance == null) {
            // avoid race condition
            synchronized (Zoo.class) {
                instance = new Zoo();
            }
        }
        return instance;
    }

    public List<Animal> getCarnivores() {
        final List<Animal> animals = new LinkedList<>();

        for (Animal animal : animalKingdom) {
            if (animal instanceof Carnivore) {
                animals.add(animal);
            }
        }

        return animals;
    }

    public List<Animal> getHerbivores() {
        final List<Animal> animals = new LinkedList<>();

        for (Animal animal : animalKingdom) {
            if (animal instanceof Herbivore) {
                animals.add(animal);
            }
        }

        return animals;
    }

    public void addAnimal(final Animal animal) {
        animalKingdom.add(animal);
    }
}
