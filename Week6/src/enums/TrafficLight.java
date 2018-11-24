package enums;

public enum TrafficLight {
    RED(5), GREEN(5), YELLOW(1);

    TrafficLight[] trafficLights = TrafficLight.values();

    private int time;

    TrafficLight(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }
}
