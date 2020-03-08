public class FullStatisticDisplay implements Observer, DisplayElement {
    private double temperature;
    private int humidity;
    private double pressure;
    private Subject weatherData;

    public FullStatisticDisplay(Subject weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(double temperature, int humidity, int pressure) {
        this.temperature = convertKtoC(temperature);
        this.humidity = humidity;
        this.pressure = convertMbarToAtm(pressure);
        display();
    }

    @Override
    public void display() {
        String formattedTemp = String.format("%.2f", temperature);
        System.out.println("Statistic:\n  temperature:"+formattedTemp+"*\n  humidity:"+humidity+"%\n  pressure:"+pressure);
    }

    private double convertKtoC(double temperatureInK){
        return temperatureInK-273.15;
    }

    private double convertMbarToAtm(int pressureInMbar){
        return pressureInMbar/1013.25;
    }
}
