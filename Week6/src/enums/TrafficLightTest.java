package enums;

public class TrafficLightTest {

    final static long timeStart = System.currentTimeMillis();
    final static long timeEnd = timeStart + 9 * 1000;
    static long currentTime = timeStart;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            waitLight(TrafficLight.RED);
            waitLight(TrafficLight.YELLOW);
            waitLight(TrafficLight.GREEN);
            waitLight(TrafficLight.YELLOW);
        }
    }

    public static void waitLight(TrafficLight light) throws InterruptedException {
        System.out.println(light);
        final int time = light.getTime() * 1000;
        Thread.sleep(time);
        currentTime += time;

        if (currentTime > timeEnd) {
            System.exit(0);
        }
    }
}
