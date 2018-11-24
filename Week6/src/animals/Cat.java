package animals;

public class Cat extends Animal implements Carnivore {
    private String name;
    private Cat other;

    @Override
    public int getRequiredEnergy() {
        return 500;
    }

    @Override
    public String getDescription() {
        return "Cat - fuzzy animal";
    }

    public String toString() {
        return "Cat{}";
    }

    @Override
    public void eat(Food other) {
        this.energy += other.getEnergyValue();
    }
}
