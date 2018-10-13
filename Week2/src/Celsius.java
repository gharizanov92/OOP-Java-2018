public class Celsius {
    private double temperature;

    public Celsius() {
    }

    public double convertToFahrenheit() {
        return 9.0 / 5.0 * temperature + 32;
    }

    public Celsius(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
