package animals;

public enum Plant {
    GRASS(100), FRUIT(300);

    private int energyValue;

    Plant(int energyValue) {
        this.energyValue = energyValue;
    }

    public int getEnergyValue() {
        return energyValue;
    }
}
