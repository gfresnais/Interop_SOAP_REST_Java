package fr.ensim.interop.eval.exo3.Controller;

import fr.ensim.interop.eval.exo2.Model.Plantation;
import fr.ensim.interop.eval.exo3.Model.Account;
import fr.ensim.interop.eval.exo3.Model.Channel;
import fr.ensim.interop.eval.exo3.Model.Message;
import fr.ensim.interop.eval.exo3.Utils.RestTemplateBasicAuth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * INUTILISÉ
 */
@RestController
public class MessengerRestController {

	// Exercice 3 REST

    private String url = "https://ensim.flox.dev/";
    private String mail = "gallien.fresnais.etu@univ-lemans.fr";
    private String token = "XD0BQEdd";

    private RestTemplateBasicAuth restTemplateBasicAuth = new RestTemplateBasicAuth(mail, token);
    private RestTemplate restTemplate;

    /*@PostMapping("/plantations")
    public ResponseEntity<Plantation> ajouterPlantation(@RequestParam("parcelle") String parcelle,
                                                     @RequestParam("nomCommun") String nomCommun,
                                                     @RequestParam("famille") String famille) {
        if(StringUtils.isBlank(parcelle) || StringUtils.isBlank(nomCommun) || StringUtils.isBlank(famille))
            return ResponseEntity.status(400).build();

        Plantation plantation = new Plantation();
        plantation.setId(fakeSeq.incrementAndGet());
        plantation.setDate(Calendar.getInstance(Locale.FRANCE).getTime());
        plantation.setParcelle(parcelle);
        plantation.setNomCommun(nomCommun);
        plantation.setFamille(famille);

        System.out.println(plantation);

        fakeDb.put(plantation.getId(), plantation);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(plantation.getId());

        return ResponseEntity.created(location).body(plantation);
    }*/

    /* ACCOUNT */
    @GetMapping("/accounts")
    public ResponseEntity<Account[]> infoAccount() {
        restTemplate = restTemplateBasicAuth.getRestTemplate();

        Account[] acc = restTemplate.getForObject(url + "accounts", Account[].class);

        return ResponseEntity.ok().body(acc);
    }

    /*@PostMapping("/accounts")
    public ResponseEntity<Account> infoAccount() {
        restTemplate = restTemplateBasicAuth.getRestTemplate();

        Account account = restTemplate.getForObject(url + "accounts/{email}", Account.class, email);

        return ResponseEntity.ok().body(account);
    }*/

    @GetMapping("/accounts/{email}")
    public ResponseEntity<Account> infoAccount(@PathVariable("email") String email) {
        if(StringUtils.isBlank(email))
            return ResponseEntity.status(400).build();
        restTemplate = restTemplateBasicAuth.getRestTemplate();

        Account account = restTemplate.getForObject(url + "accounts/{email}", Account.class, email);

        return ResponseEntity.ok().body(account);
    }


    /* CHANNELS */

    /**
     * Liste les channels
     * @return
     */
    @GetMapping("/channels")
    public ResponseEntity<Channel[]> listChannels() {
        RestTemplate restTemplate = restTemplateBasicAuth.getRestTemplate();
        Channel[] chan = restTemplate.getForObject(url + "channels", Channel[].class);
        return ResponseEntity.ok().body(chan);
    }

    /**
     * Récupère les infos d'un Channel
     * @param channelName
     * @return
     */
    @GetMapping("/channels/{channelName}")
    public ResponseEntity<Channel> infoChannel(@PathVariable("channelName") String channelName) {
        RestTemplate restTemplate = restTemplateBasicAuth.getRestTemplate();

        Channel chan = restTemplate.getForObject(url + "channels/{channelName}", Channel.class, channelName);

        return ResponseEntity.ok().body(chan);
    }


    /*@PostMapping("/channels/{channelName}")
    public ResponseEntity<Account> infoAccount(@PathVariable("channelName") String channelName) {
        restTemplate = restTemplateBasicAuth.getRestTemplate();

        Account account = restTemplate.getForObject(url + "accounts/{email}", Account.class, email);

        return ResponseEntity.ok().body(account);
    }*/


    /* CHANNEL MESSENGER */

    /**
     * Récupère les messages d'un channel
     * @param channelName
     * @return
     */
    @GetMapping("/channels/{channelName}/messages")
    public ResponseEntity<Message[]> fetchMessages(@PathVariable("channelName") String channelName) {
        if(StringUtils.isBlank(channelName))
            return ResponseEntity.status(400).build();

        RestTemplate restTemplate = restTemplateBasicAuth.getRestTemplate();

        Message[] msg = restTemplate.getForObject(url + "channels/{channelName}/messages", Message[].class, channelName);

        return ResponseEntity.ok().body(msg);
    }

    /**
     * Envoie un message sur un channel
     * @param channelName
     * @return
     */
    @PostMapping("/channels/{channelName}/messages")
    public ResponseEntity<Message> sendMessage(@PathVariable("channelName") String channelName,
                                               @RequestParam("message") String message) {
        if(StringUtils.isBlank(channelName) || StringUtils.isBlank(message))
            return ResponseEntity.status(400).build();

        restTemplate = restTemplateBasicAuth.getRestTemplate();

        restTemplate.postForObject(url + "channels/{channelName}/messages", message, Message.class, channelName);

        return ResponseEntity.ok().build();
    }
}