package inheritance;

public abstract class Animal {
    protected int energy = 0;

    public final boolean isFed() {
        return energy >= getRequiredEnergy();
    }

    protected abstract int getRequiredEnergy();

    public abstract String getDescription();
}
