package animals;

public class Panda extends Animal implements Herbivore {

    @Override
    public int getRequiredEnergy() {
        return 2500;
    }

    @Override
    public String getDescription() {
        return "Panda - eats leafs";
    }

    @Override
    public void eat(Plant plant) {
        System.out.println("Panda eats a " + plant.toString());
        this.energy += plant.getEnergyValue();
    }
}
