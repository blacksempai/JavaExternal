import generated.DeviceType;
import generated.DevicesType;
import generated.TypeType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyDOM implements Xmlable {
    private DevicesType devicesType;
    private Map<String,XmlTagToSetterCommand<DeviceType>> commandDeviceBuilder;
    private Map<String,XmlTagToSetterCommand<TypeType>> commandTypeBuilder;


    public MyDOM(){
        commandDeviceBuilder = new HashMap<>();
        commandTypeBuilder = new HashMap<>();
        fillCommandMaps();
    }

    private void fillCommandMaps(){
        commandDeviceBuilder.put("name", DeviceType::setName);
        commandDeviceBuilder.put("origin", DeviceType::setOrigin);
        commandDeviceBuilder.put("price", (d, text)->d.setPrice(Short.parseShort(text)));
        commandDeviceBuilder.put("critical", (d, text)->d.setCritical(Boolean.getBoolean(text)));
        commandTypeBuilder.put("peripheral", (t,text)->t.setPeripheral(Boolean.getBoolean(text)));
        commandTypeBuilder.put("power", (t,text)->t.setPower(Float.parseFloat(text)));
        commandTypeBuilder.put("group", TypeType::setGroup);
        commandTypeBuilder.put("port", TypeType::setPort);
    }

    public DevicesType readFromXml(String xsdLocation, String xmlLocation) {
        devicesType = new DevicesType();
        parseNodes(getNodesFromXml(xmlLocation));
        return devicesType;
    }

    private NodeList getNodesFromXml(String xmlLocation){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = factory.newDocumentBuilder();
            Document xml = db.parse(xmlLocation);
            Element mainXmlElement = xml.getDocumentElement();
            return mainXmlElement.getElementsByTagName("device");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void parseNodes(NodeList deviceNodes){
        for (int i = 0; i < deviceNodes.getLength(); i++) {
            Node device = deviceNodes.item(i);
            if (device.getNodeType()==Node.ELEMENT_NODE){
                NodeList elementNodes = device.getChildNodes();
                DeviceType deviceType = new DeviceType();
                for (int j = 0; j < elementNodes.getLength(); j++) {
                    Node element = elementNodes.item(j);
                    if (element.getNodeType()==Node.ELEMENT_NODE){
                        Element e = (Element) element;
                        deviceBuild(deviceType,e);
                    }
                }
                devicesType.getDevice().add(deviceType);
            }
        }
    }

    private void deviceBuild(DeviceType deviceType, Element e){
        if(e.getTagName()=="type")
        {
            NodeList elementNodes = e.getChildNodes();
            TypeType type = new TypeType();
            for (int i = 0; i < elementNodes.getLength(); i++) {
                Node element = elementNodes.item(i);
                if (element.getNodeType()==Node.ELEMENT_NODE){
                    Element typeElem = (Element) element;
                    typeBuild(type,typeElem);
                }
            }
            deviceType.setType(type);
        }
        else
            commandDeviceBuilder.get(e.getTagName()).set(deviceType,e.getTextContent());
    }

    private void typeBuild(TypeType type, Element typeElem){
        commandTypeBuilder.get(typeElem.getTagName()).set(type,typeElem.getTextContent());
    }

    @FunctionalInterface
    interface XmlTagToSetterCommand<T> {
        void set(T t, String text);
    }
}
