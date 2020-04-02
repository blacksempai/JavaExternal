import generated.DevicesType;

public interface Xmlable {
    DevicesType readFromXml(String xsdLocation, String xmlLocation);
}
