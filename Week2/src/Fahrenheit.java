public class Fahrenheit {
    private double temperature;

    public Fahrenheit() {
    }

    public double convertToCelsius() {
        return 5.0 / 9.0 * ( temperature - 32 );
    }

    public Fahrenheit(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
