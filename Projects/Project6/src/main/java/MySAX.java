import generated.DevicesType;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class MySAX implements Xmlable{
    private DevicesType devicesType;
    private DeviceHandler deviceHandler;
    private XMLReader reader;

    public MySAX() {
        deviceHandler = new DeviceHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(deviceHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public DevicesType readFromXml(String xsdLocation, String xmlLocation) {
        try {
            reader.parse(xmlLocation);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return deviceHandler.getDevices();
    }
}
