package inheritance;

public class Mouse extends Animal implements Herbivore {

    @Override
    public void eat(Plant plant) {
        energy += plant.getEnergy();
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    protected int getRequiredEnergy() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "Mouse - Food for cats";
    }
}
