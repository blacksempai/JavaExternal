import org.jsoup.Jsoup;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;


public class ProgramHash {
    static List<String> sonnets = new ArrayList<>(Arrays.asList(
            "http://shakespeare.mit.edu/Poetry/sonnet.I.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.II.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.III.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.IV.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.V.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.VI.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.VII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.VIII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.IX.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.X.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XI.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XIII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XIV.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XV.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XVI.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XVII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XVIII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XIX.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XX.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXI.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXIII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXIV.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXV.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXVI.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXVII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXVIII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXIX.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXX.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXI.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXIII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXIV.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXV.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXVI.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXVII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXVIII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XXXIX.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XL.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XLI.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XLII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XLIII.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XLIV.html",
            "http://shakespeare.mit.edu/Poetry/sonnet.XLV.html"
    ));

    public static String getText(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        in.close();

        return response.toString();
    }

    public static void main(String[] args) throws Exception {
        Map<String,Map<String,Integer>> m = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (String sonnet : sonnets) {
            String str = getText(sonnet);
            str = Jsoup.parse(str).text();
            String[] words = str.split("[ .:,;!?]");
            for (String word : words) {
                word=word.toLowerCase();
                if (m.get(word) == null){
                    Map<String,Integer> innerMap = new HashMap<>();
                    innerMap.put(sonnet,1);
                    m.put(word,innerMap);
                }
                else {
                    Integer freq = m.get(word).get(sonnet);
                    m.get(word).put(sonnet,(freq == null) ? 1 : freq + 1);
                }
            }
        }
        System.out.println(m.size() + " distinct words:");
        System.out.println("Choose a word from list");
        System.out.println(m.keySet());
        String userInput = br.readLine();
        m.get(userInput).entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);


    }
}