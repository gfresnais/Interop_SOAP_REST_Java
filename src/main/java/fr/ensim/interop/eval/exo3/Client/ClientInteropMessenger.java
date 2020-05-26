package fr.ensim.interop.eval.exo3.Client;

import fr.ensim.interop.eval.exo3.Model.Account;
import fr.ensim.interop.eval.exo3.Model.Channel;
import fr.ensim.interop.eval.exo3.Model.Message;
import fr.ensim.interop.eval.exo3.Utils.RestTemplateBasicAuth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class ClientInteropMessenger {
    // TODO: Exercice 3 - Implémentation d'un client du service Interop Messenger (si langage de programmation Java).

    // Utilise REST

    private String url;
    private String mail;
    private String token;

    private RestTemplateBasicAuth restTemplateBasicAuth;
    private RestTemplate restTemplate;

    /**
     * REST Client
     * @param mail
     * @param token
     * @param url
     */
    public ClientInteropMessenger(String mail, String token, String url) {
        this.mail = mail;
        this.token = token;
        this.url = url;
        restTemplateBasicAuth = new RestTemplateBasicAuth(mail, token);
        restTemplate = restTemplateBasicAuth.getRestTemplate();
    }

    /**
     * Sends a message to a given channelName
     * @param channelName
     * @param msg
     */
    public void sendMessage(String channelName, String msg) {
        restTemplate.postForObject(url + "channels/{channelName}/messages", msg, Message.class, channelName);
    }

    /**
     * Fetches messages from a channelName
     * @param channelName
     * @return
     */
    public Message[] fetchMessages(String channelName) {
        return restTemplate.getForObject(url + "channels/{channelName}/messages", Message[].class, channelName);
    }

    public static void main(String[] args) {
        String url = "https://ensim.flox.dev/";
        String mail = "gallien.fresnais.etu@univ-lemans.fr";
        String token = "XD0BQEdd";

        ClientInteropMessenger client = new ClientInteropMessenger(mail, token, url);

        String str = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de votre channel : ");
        String channel = scanner.next();

        // Entering ":q" breaks the loop and ends the app
        while( !StringUtils.equals(str, ":q") ) {
            // Fetches the messages
            Message[] messages = client.fetchMessages(channel);
            for (Message msg : messages) {
                System.out.println(msg);
            }

            System.out.print("Entrez votre message (ou :q pour quitter) : ");
            str = scanner.next();

            // Sends the message
            if( !StringUtils.equals(str, ":q") )
                client.sendMessage(channel, str);
        }

        System.out.println("Fin du programme...");
    }
}
