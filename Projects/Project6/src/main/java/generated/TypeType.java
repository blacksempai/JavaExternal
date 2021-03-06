//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.12 at 10:23:50 PM EET 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="peripheral">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="true"/>
 *               &lt;enumeration value="false"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="power" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="group">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="IO"/>
 *               &lt;enumeration value="Memory"/>
 *               &lt;enumeration value="Main"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="port">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="USB"/>
 *               &lt;enumeration value="SATA"/>
 *               &lt;enumeration value="COM"/>
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="LPT"/>
 *               &lt;enumeration value="AM4"/>
 *               &lt;enumeration value="PCI"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeType", propOrder = {
    "peripheral",
    "power",
    "group",
    "port"
})
public class TypeType {

    @XmlElement(required = true)
    protected boolean peripheral;
    protected float power;
    @XmlElement(required = true)
    protected String group;
    @XmlElement(required = true)
    protected String port;

    /**
     * Gets the value of the peripheral property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public boolean getPeripheral() {
        return peripheral;
    }

    /**
     * Sets the value of the peripheral property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeripheral(boolean value) {
        this.peripheral = value;
    }

    /**
     * Gets the value of the power property.
     * 
     */
    public float getPower() {
        return power;
    }

    /**
     * Sets the value of the power property.
     * 
     */
    public void setPower(float value) {
        this.power = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPort(String value) {
        this.port = value;
    }

    @Override
    public String toString() {
        return "TypeType{" +
                "peripheral='" + peripheral + '\'' +
                ", power=" + power +
                ", group='" + group + '\'' +
                ", port='" + port + '\'' +
                '}';
    }
}
