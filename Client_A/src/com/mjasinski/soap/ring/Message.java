
package com.mjasinski.soap.ring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Message complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Message">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="soapMessage" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", propOrder = {
    "soapMessage"
})
public class Message {

    @XmlElement(required = true, nillable = true)
    protected byte[] soapMessage;

    /**
     * Gets the value of the soapMessage property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getSoapMessage() {
        return soapMessage;
    }

    /**
     * Sets the value of the soapMessage property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setSoapMessage(byte[] value) {
        this.soapMessage = value;
    }

}
