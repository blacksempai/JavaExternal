import generated.DevicesType;

public class Project6 {
    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        DevicesType devices = parser.parse("Devices.xsd","Devices.xml");
    }
}
