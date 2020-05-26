
package flox.dev.ensim.interop.server.messenger.api.soap;

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
 * JAX-WS RI 2.2.9-b14002
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MessageServiceEndpointService", targetNamespace = "http://soap.api.messenger.server.interop.ensim.dev.flox/", wsdlLocation = "file:/home/gallmanja/Documents/Travail/ENSIM/4A-Info/Semestre%208/Interoperabilite/tp-eval-2020/src/main/resources/MessageService.wsdl")
public class MessageServiceEndpointService
    extends Service
{

    private final static URL MESSAGESERVICEENDPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException MESSAGESERVICEENDPOINTSERVICE_EXCEPTION;
    private final static QName MESSAGESERVICEENDPOINTSERVICE_QNAME = new QName("http://soap.api.messenger.server.interop.ensim.dev.flox/", "MessageServiceEndpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/gallmanja/Documents/Travail/ENSIM/4A-Info/Semestre%208/Interoperabilite/tp-eval-2020/src/main/resources/MessageService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MESSAGESERVICEENDPOINTSERVICE_WSDL_LOCATION = url;
        MESSAGESERVICEENDPOINTSERVICE_EXCEPTION = e;
    }

    public MessageServiceEndpointService() {
        super(__getWsdlLocation(), MESSAGESERVICEENDPOINTSERVICE_QNAME);
    }

    public MessageServiceEndpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MESSAGESERVICEENDPOINTSERVICE_QNAME, features);
    }

    public MessageServiceEndpointService(URL wsdlLocation) {
        super(wsdlLocation, MESSAGESERVICEENDPOINTSERVICE_QNAME);
    }

    public MessageServiceEndpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MESSAGESERVICEENDPOINTSERVICE_QNAME, features);
    }

    public MessageServiceEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MessageServiceEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MessageServiceEndpoint
     */
    @WebEndpoint(name = "MessageServiceEndpointPort")
    public MessageServiceEndpoint getMessageServiceEndpointPort() {
        return super.getPort(new QName("http://soap.api.messenger.server.interop.ensim.dev.flox/", "MessageServiceEndpointPort"), MessageServiceEndpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MessageServiceEndpoint
     */
    @WebEndpoint(name = "MessageServiceEndpointPort")
    public MessageServiceEndpoint getMessageServiceEndpointPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.api.messenger.server.interop.ensim.dev.flox/", "MessageServiceEndpointPort"), MessageServiceEndpoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MESSAGESERVICEENDPOINTSERVICE_EXCEPTION!= null) {
            throw MESSAGESERVICEENDPOINTSERVICE_EXCEPTION;
        }
        return MESSAGESERVICEENDPOINTSERVICE_WSDL_LOCATION;
    }

}