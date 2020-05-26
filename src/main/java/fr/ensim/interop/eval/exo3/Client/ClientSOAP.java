package fr.ensim.interop.eval.exo3.Client;

import flox.dev.ensim.interop.server.messenger.api.soap.Message;
import flox.dev.ensim.interop.server.messenger.api.soap.MessageServiceEndpoint;
import flox.dev.ensim.interop.server.messenger.api.soap.MessageServiceEndpointService;
import flox.dev.ensim.interop.server.messenger.api.soap.SOAPException_Exception;

import javax.xml.ws.BindingProvider;
import java.util.List;

public class ClientSOAP {
    public static void main(String[] args) {
        String url = "https://ensim.flox.dev/";
        String mail = "gallien.fresnais.etu@univ-lemans.fr";
        String token = "XD0BQEdd";

        // Create service
        MessageServiceEndpointService service = new MessageServiceEndpointService();

        // Client based on service
        MessageServiceEndpoint client = service.getMessageServiceEndpointPort();

        // Add basic authentication
        BindingProvider bp = (BindingProvider) client;
        bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, mail);
        bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, token);

        try {
            // Sending message
            String str = client.sendMessage("groupeN", "coucou");
            System.out.println(str);
        } catch (SOAPException_Exception e) {
            e.printStackTrace();
        }

        // Fetching messages
        List<Message> list = client.fetchMessages("groupeN");
        for (Message msg : list) {
            System.out.println("(" + msg.getDateTime() + ")" + msg.getSender() + " : " + msg.getContent());
        }
    }
}
