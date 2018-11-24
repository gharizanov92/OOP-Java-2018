package animals;

public class Mouse extends Animal implements Herbivore, Food {
    @Override
    public int getRequiredEnergy() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Mouse - food for cats";
    }

    @Override
    public int getEnergyValue() {
        return 600;
    }

    @Override
    public void eat(Plant plant) {

    }
}
