public class FullStatisticDisplay implements Observer, DisplayElement {
    private double temperature;
    private int humidity;
    private int pressure;
    private Subject weatherData;

    public FullStatisticDisplay(Subject weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(double temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Statistic:\n  temperature:"+temperature+"*\n  humidity:"+humidity+"%\n  pressure:"+pressure);
    }
}
