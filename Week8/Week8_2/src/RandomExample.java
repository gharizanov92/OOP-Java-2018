import java.util.Random;

public class RandomExample {
    public static final int SEED = 10;
    public static void main(String[] args) {
        Random random = new Random(SEED);

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }
}
