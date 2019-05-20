
package com.mjasinski.soap.ring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getSoapMessageReturn" type="{http://ring.soap.mjasinski.com}Message"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getSoapMessageReturn"
})
@XmlRootElement(name = "getSoapMessageResponse")
public class GetSoapMessageResponse {

    @XmlElement(required = true)
    protected Message getSoapMessageReturn;

    /**
     * Gets the value of the getSoapMessageReturn property.
     * 
     * @return
     *     possible object is
     *     {@link Message }
     *     
     */
    public Message getGetSoapMessageReturn() {
        return getSoapMessageReturn;
    }

    /**
     * Sets the value of the getSoapMessageReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Message }
     *     
     */
    public void setGetSoapMessageReturn(Message value) {
        this.getSoapMessageReturn = value;
    }

}
