package enums;

public enum  TrafficLight {
    RED(1), YELLOW(1), GREEN(1);

    private int time;

    TrafficLight(int time) {
        this.time = time;
    }

    public int getDelay() {
        return time;
    }
}
