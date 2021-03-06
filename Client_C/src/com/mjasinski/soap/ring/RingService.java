
package com.mjasinski.soap.ring;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RingService", targetNamespace = "http://ring.soap.mjasinski.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RingService {


    /**
     * 
     * @return
     *     returns com.mjasinski.soap.ring.Message
     */
    @WebMethod
    @WebResult(name = "getSoapMessageReturn", targetNamespace = "http://ring.soap.mjasinski.com")
    @RequestWrapper(localName = "getSoapMessage", targetNamespace = "http://ring.soap.mjasinski.com", className = "com.mjasinski.soap.ring.GetSoapMessage")
    @ResponseWrapper(localName = "getSoapMessageResponse", targetNamespace = "http://ring.soap.mjasinski.com", className = "com.mjasinski.soap.ring.GetSoapMessageResponse")
    public Message getSoapMessage();

    /**
     * 
     * @param message
     */
    @WebMethod
    @RequestWrapper(localName = "forwardMessage", targetNamespace = "http://ring.soap.mjasinski.com", className = "com.mjasinski.soap.ring.ForwardMessage")
    @ResponseWrapper(localName = "forwardMessageResponse", targetNamespace = "http://ring.soap.mjasinski.com", className = "com.mjasinski.soap.ring.ForwardMessageResponse")
    public void forwardMessage(
        @WebParam(name = "message", targetNamespace = "http://ring.soap.mjasinski.com")
        Message message);

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "hasPendingMessagesReturn", targetNamespace = "http://ring.soap.mjasinski.com")
    @RequestWrapper(localName = "hasPendingMessages", targetNamespace = "http://ring.soap.mjasinski.com", className = "com.mjasinski.soap.ring.HasPendingMessages")
    @ResponseWrapper(localName = "hasPendingMessagesResponse", targetNamespace = "http://ring.soap.mjasinski.com", className = "com.mjasinski.soap.ring.HasPendingMessagesResponse")
    public boolean hasPendingMessages();

}
