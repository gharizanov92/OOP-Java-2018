package enums;

public class TrafficLightTest {
    private final static long startTime = System.currentTimeMillis();
    private final static long endTime = startTime + 5000;
    private static long currentTime = startTime;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            waitLight(TrafficLight.RED);
            waitLight(TrafficLight.YELLOW);
            waitLight(TrafficLight.GREEN);
        }
    }

    private static void waitLight(TrafficLight light) throws InterruptedException {
        System.out.println(light);
        final int delay = light.getDelay() * 1000;
        Thread.sleep(delay);
        currentTime += delay;
        if (currentTime > endTime) {
            System.exit(0);
        }
    }
}
