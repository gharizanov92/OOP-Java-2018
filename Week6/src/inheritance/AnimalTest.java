package inheritance;

import java.util.List;

public class AnimalTest {
    public static void main(String[] args) {
        // Animal animal = new Animal();
        Animal cat = new Cat();
        Animal dog = new Dog();
        Animal panda = new Panda();
        Animal mouse = new Mouse();

        final Zoo zoo = Zoo.getInstance();

        zoo.addAnimal(cat);
        zoo.addAnimal(dog);
        zoo.addAnimal(panda);
        zoo.addAnimal(mouse);

        System.out.println("Carnivores in Zoo: ");
        final List<Animal> carnivores = zoo.getCarnivores();
        for (Animal carnivore : carnivores) {
            System.out.println(carnivore.getDescription());
        }
        System.out.println("------------------");

        System.out.println("Herbivores in Zoo: ");
        final List<Animal> herbivores = zoo.getHerbivores();
        for (Animal herbivore : herbivores) {
            System.out.println(herbivore.getDescription());
        }
    }
}
