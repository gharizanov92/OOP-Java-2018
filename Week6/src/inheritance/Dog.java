package inheritance;

public class Dog extends Animal implements Carnivore {

    @Override
    protected int getRequiredEnergy() {
        return 1500;
    }

    @Override
    public String getDescription() {
        return "Dog - Man's best friend";
    }

    @Override
    public void eat(Herbivore other) {
        energy += other.getEnergy();
    }
}
