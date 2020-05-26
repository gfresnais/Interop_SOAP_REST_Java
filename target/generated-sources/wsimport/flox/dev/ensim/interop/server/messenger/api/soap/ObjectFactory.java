
package flox.dev.ensim.interop.server.messenger.api.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the flox.dev.ensim.interop.server.messenger.api.soap package. 
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

    private final static QName _SendMessageResponse_QNAME = new QName("http://soap.api.messenger.server.interop.ensim.dev.flox/", "sendMessageResponse");
    private final static QName _FetchMessages_QNAME = new QName("http://soap.api.messenger.server.interop.ensim.dev.flox/", "fetchMessages");
    private final static QName _SendMessage_QNAME = new QName("http://soap.api.messenger.server.interop.ensim.dev.flox/", "sendMessage");
    private final static QName _SOAPException_QNAME = new QName("http://soap.api.messenger.server.interop.ensim.dev.flox/", "SOAPException");
    private final static QName _FetchMessagesResponse_QNAME = new QName("http://soap.api.messenger.server.interop.ensim.dev.flox/", "fetchMessagesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: flox.dev.ensim.interop.server.messenger.api.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FetchMessagesResponse }
     * 
     */
    public FetchMessagesResponse createFetchMessagesResponse() {
        return new FetchMessagesResponse();
    }

    /**
     * Create an instance of {@link SOAPException }
     * 
     */
    public SOAPException createSOAPException() {
        return new SOAPException();
    }

    /**
     * Create an instance of {@link FetchMessages }
     * 
     */
    public FetchMessages createFetchMessages() {
        return new FetchMessages();
    }

    /**
     * Create an instance of {@link SendMessage }
     * 
     */
    public SendMessage createSendMessage() {
        return new SendMessage();
    }

    /**
     * Create an instance of {@link SendMessageResponse }
     * 
     */
    public SendMessageResponse createSendMessageResponse() {
        return new SendMessageResponse();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.api.messenger.server.interop.ensim.dev.flox/", name = "sendMessageResponse")
    public JAXBElement<SendMessageResponse> createSendMessageResponse(SendMessageResponse value) {
        return new JAXBElement<SendMessageResponse>(_SendMessageResponse_QNAME, SendMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchMessages }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.api.messenger.server.interop.ensim.dev.flox/", name = "fetchMessages")
    public JAXBElement<FetchMessages> createFetchMessages(FetchMessages value) {
        return new JAXBElement<FetchMessages>(_FetchMessages_QNAME, FetchMessages.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.api.messenger.server.interop.ensim.dev.flox/", name = "sendMessage")
    public JAXBElement<SendMessage> createSendMessage(SendMessage value) {
        return new JAXBElement<SendMessage>(_SendMessage_QNAME, SendMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.api.messenger.server.interop.ensim.dev.flox/", name = "SOAPException")
    public JAXBElement<SOAPException> createSOAPException(SOAPException value) {
        return new JAXBElement<SOAPException>(_SOAPException_QNAME, SOAPException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FetchMessagesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.api.messenger.server.interop.ensim.dev.flox/", name = "fetchMessagesResponse")
    public JAXBElement<FetchMessagesResponse> createFetchMessagesResponse(FetchMessagesResponse value) {
        return new JAXBElement<FetchMessagesResponse>(_FetchMessagesResponse_QNAME, FetchMessagesResponse.class, null, value);
    }

}
