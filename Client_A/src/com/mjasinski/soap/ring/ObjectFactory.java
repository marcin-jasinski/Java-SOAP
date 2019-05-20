
package com.mjasinski.soap.ring;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mjasinski.soap.ring package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mjasinski.soap.ring
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSoapMessageResponse }
     * 
     */
    public GetSoapMessageResponse createGetSoapMessageResponse() {
        return new GetSoapMessageResponse();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link ForwardMessageResponse }
     * 
     */
    public ForwardMessageResponse createForwardMessageResponse() {
        return new ForwardMessageResponse();
    }

    /**
     * Create an instance of {@link HasPendingMessages }
     * 
     */
    public HasPendingMessages createHasPendingMessages() {
        return new HasPendingMessages();
    }

    /**
     * Create an instance of {@link HasPendingMessagesResponse }
     * 
     */
    public HasPendingMessagesResponse createHasPendingMessagesResponse() {
        return new HasPendingMessagesResponse();
    }

    /**
     * Create an instance of {@link GetSoapMessage }
     * 
     */
    public GetSoapMessage createGetSoapMessage() {
        return new GetSoapMessage();
    }

    /**
     * Create an instance of {@link ForwardMessage }
     * 
     */
    public ForwardMessage createForwardMessage() {
        return new ForwardMessage();
    }

}
