package fr.ensim.interop.eval.exo3.Controller;

import fr.ensim.interop.eval.exo2.Model.Plantation;
import fr.ensim.interop.eval.exo3.Model.Channel;
import fr.ensim.interop.eval.exo3.Model.Message;
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

@RestController
public class MessengerRestController {

	// Exercice 3 REST

    private RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

    private String url = "https://ensim.flox.dev/";
    private String mail = "gallien.fresnais.etu@univ-lemans.fr";
    private String token = "XD0BQEdd";

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


    /* CHANNELS */

    /**
     * Liste les channels
     * @return
     */
    @GetMapping("/channels")
    public ResponseEntity<Channel> listChannels() {
        RestTemplate restTemplate = restTemplateBuilder.basicAuthorization(mail, token).build();
       Channel chan = restTemplate.getForObject(url + "channels", Channel.class);
        return ResponseEntity.ok().body(chan);
    }


    /* CHANNEL MESSENGER */

    /**
     * Envoie un message sur un channel
     * @param channelName
     * @return
     */
    /*@PostMapping("/channels/{channelName}/messages")
    public ResponseEntity<Plantation> supprimerPlantation(@PathVariable("channelName") String channelName) {
        if(StringUtils.isBlank(channelName))
            return ResponseEntity.status(400).build();
        return ResponseEntity.notFound().build();
    }*/

    /**
     * Récupère les messages d'un channel
     * @param channelName
     * @return
     */
    @GetMapping("/channels/{channelName}/messages")
    public ResponseEntity<Message> fetchMessages(@PathVariable("channelName") String channelName) {
        if(StringUtils.isBlank(channelName))
            return ResponseEntity.status(400).build();

        RestTemplate restTemplate = restTemplateBuilder.basicAuthorization(mail, token).build();

        return restTemplate.getForEntity(url + "channels/{channelName}/messages", Message.class, channelName);
    }
}