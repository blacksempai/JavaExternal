import generated.DeviceType;
import generated.DevicesType;
import generated.TypeType;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyStAX implements Xmlable {
    private DevicesType devicesType;
    private XMLInputFactory factory;

    public MyStAX() {
        this.devicesType = new DevicesType();
        this.factory = XMLInputFactory.newInstance();
    }

    public DevicesType readFromXml(String xsdLocation, String xmlLocation) {
        FileInputStream inputStream;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(xmlLocation));
            reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()){
                int tegType = reader.next();
                if (tegType == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    if (DeviceFields.valueOf(name.toUpperCase())==DeviceFields.DEVICE){
                        DeviceType device = buildDevice(reader);
                        devicesType.getDevice().add(device);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return devicesType;
    }

    private DeviceType buildDevice(XMLStreamReader reader) throws XMLStreamException {
        DeviceType device = new DeviceType();
        String name;

        while(reader.hasNext()){
            int tegType = reader.next();
            if (tegType == XMLStreamConstants.START_ELEMENT){
                name = reader.getLocalName();
                switch (DeviceFields.valueOf(name.toUpperCase())){
                    case NAME:
                        device.setName(getXMLText(reader));
                        break;
                    case ORIGIN:
                        device.setOrigin(getXMLText(reader));
                        break;
                    case PRICE:
                        device.setPrice(Short.parseShort(getXMLText(reader)));
                        break;
                    case CRITICAL:
                        device.setCritical(Boolean.getBoolean(getXMLText(reader)));
                        break;
                    case TYPE:
                        device.setType(buildType(reader));
                        break;
                }
            }
            else if (tegType == XMLStreamConstants.END_ELEMENT){
                name = reader.getLocalName();
                if (DeviceFields.valueOf(name.toUpperCase())==DeviceFields.DEVICE)
                    break;
            }
        }
        return device;
    }

    private TypeType buildType(XMLStreamReader reader) throws XMLStreamException {
        TypeType type = new TypeType();
        String name;

        while(reader.hasNext()){
            int tegType = reader.next();
            if (tegType == XMLStreamConstants.START_ELEMENT){
                name = reader.getLocalName();
                switch (DeviceFields.valueOf(name.toUpperCase())){
                    case PORT:
                        type.setPort(getXMLText(reader));
                        break;
                    case POWER:
                        type.setPower(Float.parseFloat(getXMLText(reader)));
                        break;
                    case GROUP:
                        type.setGroup(getXMLText(reader));
                        break;
                    case PERIPHERAL:
                        type.setPeripheral(Boolean.getBoolean(getXMLText(reader)));
                        break;
                    default:
                        break;
                }
            }
            else if (tegType == XMLStreamConstants.END_ELEMENT){
                name = reader.getLocalName();
                if (DeviceFields.valueOf(name.toUpperCase())==DeviceFields.TYPE)
                    break;
            }
        }
        return type;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
