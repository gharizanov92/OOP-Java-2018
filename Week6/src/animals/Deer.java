package animals;

public class Deer extends Animal implements Herbivore {
    @Override
    public int getRequiredEnergy() {
        return 2000;
    }

    @Override
    public String getDescription() {
        return "Deer";
    }

    @Override
    public void eat(Plant plant) {
        energy += plant.getEnergyValue();
    }
}
