public class OpenWeather {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.registerObserver(new CurrentConditionsDisplay(weatherData));
        weatherData.registerObserver(new FullStatisticDisplay(weatherData));
        weatherData.registerObserver(new PredictionDisplay(weatherData));
        weatherData.updateMeasurements("Kyiv");
        /*
        weatherData.updateMeasurements("London");
        weatherData.updateMeasurements("Paris");
        weatherData.updateMeasurements("Reshetylivka");
        weatherData.updateMeasurements("Talalaivka");
        */
    }
}
