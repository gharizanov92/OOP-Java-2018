package inheritance;

public class Cat extends Animal implements Carnivore {

    @Override
    protected int getRequiredEnergy() {
        return 500;
    }

    @Override
    public String getDescription() {
        return "Cat - A fuzzy animal that meows";
    }

    public void eat() {
        System.out.println();
    }

    @Override
    public void eat(Herbivore other) {
        energy += other.getEnergy();
    }
}
