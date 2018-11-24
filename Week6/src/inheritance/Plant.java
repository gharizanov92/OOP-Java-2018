package inheritance;

public enum Plant {
    GRASS(200),
    FRUIT(400);

    int energy;

    Plant(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }
}
