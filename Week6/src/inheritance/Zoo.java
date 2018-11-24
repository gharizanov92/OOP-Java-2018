package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animalKingdom;

    private static Zoo instance;

    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
        }

        return instance;
    }

    private Zoo() {
        animalKingdom = new ArrayList<>();
    }

    public List<Animal> getCarnivores() {
        final List<Animal> carnivores = new ArrayList<>();

        for (Animal animal : animalKingdom) {
            if (animal instanceof Carnivore) {
                carnivores.add(animal);
            }
        }

        return carnivores;
    }

    public List<Animal> getHerbivores() {
        final List<Animal> herbivores = new ArrayList<>();

        for (Animal animal : animalKingdom) {
            if (animal instanceof Herbivore) {
                herbivores.add(animal);
            }
        }

        return herbivores;
    }

    public void addAnimal(final Animal animal) {
        this.animalKingdom.add(animal);
    }
}
