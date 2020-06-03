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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
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
     * @throws HttpClientErrorException
     */
    public Message[] fetchMessages(String channelName) throws HttpClientErrorException {
        return restTemplate.getForObject(url + "channels/{channelName}/messages", Message[].class, channelName);
    }

    /**
     * Creates a new channel from a channelName
     * @param channelName
     * @return
     * @throws RestClientException
     */
    public Channel createChannel(String channelName) throws RestClientException{
        return restTemplate.postForObject(url + "channels/{channelName}", channelName, Channel.class, channelName);
    }

    /**
     * TODO test it and implement it the correct way
     * !!! It doesn't work as it is !!!
     * Adds a new member to a channel with their mail address
     * @param channelName
     * @param memberMail
     * @throws RestClientException
     */
    public void joinChannel(String channelName, String memberMail) throws RestClientException {
        restTemplate.postForObject(url + "channels/{channelName}/members/{email}", channelName, Channel.class, channelName, memberMail);
    }

    public static void main(String[] args) {
        String url = "https://ensim.flox.dev/";
        String mail = "gallien.fresnais.etu@univ-lemans.fr";
        String token = "XD0BQEdd";

        ClientInteropMessenger client = new ClientInteropMessenger(mail, token, url);

        String str = "";
        String mode = "";
        String channel = "";

        Scanner scanner = new Scanner(System.in);

        // Entering ":q" breaks the loop and ends the app
        while ( !StringUtils.equals(str, ":q") ) {
            // Initialize the mode
            if( StringUtils.isBlank(mode) ) {
                System.out.println("Voulez-vous créer ou rejoindre un channel ? ':c' / ':r' (:q pour quitter)");
                mode = scanner.next();

                if( StringUtils.equals(mode, ":q") ) break;
            }

            // Initialize the channelName
            if( StringUtils.isBlank(channel) ) {
                System.out.print("Entrez le nom de votre channel : ");
                channel = scanner.next();
            }

            // Channel creation mode
            if ( StringUtils.equals(mode, ":c") ) {
                try {
                    if( client.createChannel(channel) != null ) mode = ":r";
                } catch (RestClientException e) {
                    System.out.println("Erreur création channel : " + e.getMessage());
                    mode = "";
                    channel = "";
                }
            }

            // Channel join mode and allows sending messages
            if( StringUtils.equals(mode, ":r") ) {
                System.out.println("Connexion au channel : " + channel);
                System.out.println("Attente de messages (5 secondes)...");
                try {
                    // Waits 5 seconds the hard way
                    Thread.sleep(5000);

                    // Fetches the messages
                    Message[] messages = client.fetchMessages(channel);
                    for (Message msg : messages) {
                        System.out.println(msg);
                    }

                    System.out.print("Entrez votre message (:q pour quitter) : ");
                    str = scanner.next();

                    // Sends the message
                    if( !StringUtils.equals(str, ":q") )
                        client.sendMessage(channel, str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (HttpClientErrorException e) {
                    System.out.println("Erreur de connexion : " + e.getMessage());
                    channel = "";
                }
            }
        }

        System.out.println("Fin du programme...");
    }
}
