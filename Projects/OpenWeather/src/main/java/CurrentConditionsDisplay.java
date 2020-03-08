public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private double temperature;
    private int humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(double temperature, int humidity, int pressure) {
        this.temperature = convertKtoF(temperature);
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        String formattedTemp = String.format("%.2f", temperature);
        System.out.println("Current conditions: "+formattedTemp+"F degrees and "+humidity+"% humidity");
    }

    private double convertKtoF(double temperatureInK){
        return (temperatureInK-32)*5/9;
    }
}
