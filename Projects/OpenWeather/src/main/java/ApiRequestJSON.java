import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequestJSON {
    private HttpURLConnection connection = null;
    private String apiKey = "8c84aabeaf93abfa5f1761e6d2320e0e";
    private String apiRequest = "http://api.openweathermap.org/data/2.5/weather?";

    public String getApiRequest(String city) {
        try {
            URL url = new URL(apiRequest+"q="+city+"&APPID="+apiKey);
            connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            br.close();
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}