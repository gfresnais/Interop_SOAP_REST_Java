package fr.ensim.interop.eval.exo3;

import fr.ensim.interop.eval.exo3.Model.Account;
import fr.ensim.interop.eval.exo3.Model.Channel;
import fr.ensim.interop.eval.exo3.Model.Message;
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

public class ClientInteropMessenger {
    // TODO: Exercice 3 - Implémentation d'un client du service Interop Messenger (si langage de programmation Java).

    public static void main(String[] args) {
        String url = "https://ensim.flox.dev/";
        String mail = "gallien.fresnais.etu@univ-lemans.fr";
        String token = "XD0BQEdd";

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(mail, token));
        restTemplate.getInterceptors().add((httpRequest, bytes, clientHttpRequestExecution) -> {
            httpRequest.getHeaders().set("User-Agent", "toto");
            return clientHttpRequestExecution.execute(httpRequest, bytes);
        });

        Account account = restTemplate.getForObject(url + "accounts/{email}", Account.class, mail);
        System.out.println(account);
    }
}
