import generated.DeviceType;
import generated.DevicesType;
import generated.TypeType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Arrays;
import java.util.EnumSet;

public class DeviceHandler extends DefaultHandler {
    private DevicesType devicesType;
    private DeviceType current;
    private TypeType currentType;
    private DeviceFields currentField;
    private EnumSet<DeviceFields> withText;

    public DeviceHandler() {
        this.devicesType = new DevicesType();
        withText = EnumSet.copyOf(Arrays.asList(DeviceFields.values()));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("device".equals(localName)) {
            current = new DeviceType();
            currentType = new TypeType();
        }
        else{
            DeviceFields temp = DeviceFields.valueOf(localName.toUpperCase());
            if(withText.contains(temp)){
                currentField = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("type".equals(localName)){
            current.setType(currentType);
        }
        if ("device".equals(localName)){
            devicesType.getDevice().add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch,start,length).trim();
        if (currentField!=null) {
            switch (currentField) {
                case NAME:
                    current.setName(s);
                    break;
                case ORIGIN:
                    current.setOrigin(s);
                    break;
                case PRICE:
                    current.setPrice(Short.parseShort(s));
                    break;
                case CRITICAL:
                    current.setCritical(Boolean.getBoolean(s));
                    break;
                case PORT:
                    currentType.setPort(s);
                    break;
                case GROUP:
                    currentType.setGroup(s);
                    break;
                case PERIPHERAL:
                    currentType.setPeripheral(Boolean.getBoolean(s));
                    break;
                case POWER:
                    currentType.setPower(Float.parseFloat(s));
                    break;
                default:
                    break;
            }
        }
        currentField = null;
    }

    public DevicesType getDevices(){
        return devicesType;
    }
}
