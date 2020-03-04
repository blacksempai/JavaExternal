public class PredictionDisplay implements Observer, DisplayElement {
    private Subject weatherData;

    public PredictionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void display() {
        System.out.println("You are very nice person and you will have a good day!");
    }

    @Override
    public void update(double temperature, int humidity, int pressure) {
        display();
    }
}
