package animals;

public class AnimalTest {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        Animal panda = new Panda();
        Animal deer = new Deer();
        Animal mouse = new Mouse();

        final Zoo zoo = Zoo.getInstance();
        zoo.addAnimal(cat);
        zoo.addAnimal(cat);
        zoo.addAnimal(dog);
        zoo.addAnimal(panda);
        zoo.addAnimal(deer);
        zoo.addAnimal(mouse);

        final String description = panda.getDescription();

        System.out.println("All descriptions: ");
        System.out.println(dog.getName());
        System.out.println(description);
        System.out.println(cat.getDescription());
        System.out.println(dog.getDescription());

        System.out.println("----------------");
        System.out.println("Feeding panda...");
        while (!panda.isFed()) {
            System.out.println("Panda is hungry");
            if (panda instanceof Panda) {
                ((Panda) panda).eat(Plant.FRUIT);
            }
        }

        System.out.println("----------------");

        if (cat instanceof Cat) {
            System.out.println("Is cat fed? ");
            ((Cat) cat).eat(new Mouse());
            System.out.println(cat.isFed());
        }


        System.out.println("Our Zoo has the following carnivores: ");
        for (Animal animal : zoo.getCarnivores()) {
            System.out.println(animal.getDescription());
        }


        System.out.println("----------------");
        System.out.println("Our Zoo has the following herbivores: ");
        for (Animal animal : zoo.getHerbivores()) {
            System.out.println(animal.getDescription());
        }

    }
}
