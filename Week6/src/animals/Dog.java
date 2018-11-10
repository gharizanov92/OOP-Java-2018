package animals;

public class Dog extends Animal {
    @Override
    public int getRequiredEnergy() {
        return 1500;
    }

    public static String getName() {
        return "Dog";
    }

    public String getDescription() {
        return "Dog - Man's best friend";
    }
}
