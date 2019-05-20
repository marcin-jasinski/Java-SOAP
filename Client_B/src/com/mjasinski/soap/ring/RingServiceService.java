
package com.mjasinski.soap.ring;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "RingServiceService", targetNamespace = "http://ring.soap.mjasinski.com", wsdlLocation = "http://localhost:8082/RingSOAP/services/RingService?wsdl")
public class RingServiceService
    extends Service
{

    private final static URL RINGSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException RINGSERVICESERVICE_EXCEPTION;
    private final static QName RINGSERVICESERVICE_QNAME = new QName("http://ring.soap.mjasinski.com", "RingServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8082/RingSOAP/services/RingService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RINGSERVICESERVICE_WSDL_LOCATION = url;
        RINGSERVICESERVICE_EXCEPTION = e;
    }

    public RingServiceService() {
        super(__getWsdlLocation(), RINGSERVICESERVICE_QNAME);
    }

    public RingServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RINGSERVICESERVICE_QNAME, features);
    }

    public RingServiceService(URL wsdlLocation) {
        super(wsdlLocation, RINGSERVICESERVICE_QNAME);
    }

    public RingServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RINGSERVICESERVICE_QNAME, features);
    }

    public RingServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RingServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns RingService
     */
    @WebEndpoint(name = "RingService")
    public RingService getRingService() {
        return super.getPort(new QName("http://ring.soap.mjasinski.com", "RingService"), RingService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RingService
     */
    @WebEndpoint(name = "RingService")
    public RingService getRingService(WebServiceFeature... features) {
        return super.getPort(new QName("http://ring.soap.mjasinski.com", "RingService"), RingService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RINGSERVICESERVICE_EXCEPTION!= null) {
            throw RINGSERVICESERVICE_EXCEPTION;
        }
        return RINGSERVICESERVICE_WSDL_LOCATION;
    }

}
