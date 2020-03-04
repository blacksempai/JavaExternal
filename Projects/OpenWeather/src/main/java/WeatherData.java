import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observers;
    private double temperature;
    private int humidity;
    private int pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature,humidity,pressure);
        }
    }

    public void updateMeasurements(String city){
        ApiRequestJSON apiRequestJSON = new ApiRequestJSON();
        String apiResponse = apiRequestJSON.getApiRequest(city);
        JSONObject jsonObject = new JSONObject(apiResponse);
        JSONObject main = (JSONObject)jsonObject.get("main");
        double temp = (Double) main.get("temp");
        int humid = (Integer) main.get("humidity");
        int press = (Integer) main.get("pressure");
        setMeasurements(temp,humid,press);
    }

    private void setMeasurements(double temperature, int humidity, int pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged(){
        notifyObservers();
    }
}