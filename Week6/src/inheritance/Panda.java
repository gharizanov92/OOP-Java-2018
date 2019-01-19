package inheritance;

public class Panda extends Animal {

    @Override
    protected int getRequiredEnergy() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
