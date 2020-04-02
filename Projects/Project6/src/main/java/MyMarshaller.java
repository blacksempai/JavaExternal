import generated.DevicesType;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;


public class MyMarshaller implements Xmlable{

    public DevicesType readFromXml(String xsdLocation, String xmlLocation) {
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(DevicesType.class);
            Unmarshaller um = context.createUnmarshaller();
            File schemaLocation = new File(xsdLocation);
            SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Schema schema = factory.newSchema(schemaLocation);
            um.setSchema(schema);
            File xml = new File(xmlLocation);
            return (DevicesType) um.unmarshal(xml);
        } catch (JAXBException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DevicesType writeToXml(String xmlLocation) {
        return null;
    }
}
