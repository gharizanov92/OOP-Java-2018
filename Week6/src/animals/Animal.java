package animals;

public abstract class Animal {
    protected int energy = 0;

    // final means that it cannot be overridden
    public final boolean isFed() {
        return energy > getRequiredEnergy();
    }

    // static methods CAN NOT be overridden
    public static String getName() {
        return "Animal";
    }

    public abstract int getRequiredEnergy();

    public abstract String getDescription();
}
