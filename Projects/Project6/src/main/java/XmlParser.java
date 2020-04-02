import generated.DeviceType;
import generated.DevicesType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class XmlParser {
    List<Xmlable> command;
    DevicesType devices;
    BufferedReader br;

    public XmlParser() {
        command = new ArrayList<>();
        command.add(new MyMarshaller());
        command.add(new MyDOM());
        command.add(new MySAX());
        command.add(new MyStAX());
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public DevicesType parse(String xsdLocation, String xmlLocation) {
        printParsingMenu();
        Xmlable parser = command.get(getUserInput());
        devices = parser.readFromXml(xsdLocation, xmlLocation);
        devices.getDevice().sort(Comparator.comparingInt(DeviceType::getPrice));
        System.out.println(devices);
        return devices;
    }

    private void printParsingMenu(){
        System.out.println("Choose parsing method");
        System.out.println("1:Marshaller");
        System.out.println("2:DOM");
        System.out.println("3:SAX");
        System.out.println("4:StAX");
    }

    private int getUserInput(){
        int input=0;
        try {
            input = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException ignored) {
        }
        if(input<1||input>4){
            System.out.println("Type an integer from 1 to 4 please");
            return getUserInput();
        }
        else return input-1;
    }

}
