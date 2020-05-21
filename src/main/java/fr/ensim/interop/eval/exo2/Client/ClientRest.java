package fr.ensim.interop.eval.exo2.Client;

import fr.ensim.interop.eval.exo2.Model.Plantation;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ClientRest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:9090/plantations";

        Plantation plantation = restTemplate.postForObject(url + "?parcelle={parcelle}&nomCommun={nomCommun}&famille={famille}",
                                                        null,
                                                            Plantation.class,
                                                "tata",
                                                            "otto",
                                                            "tete");
        System.out.println("POST => " + plantation);

        if( plantation != null ) {
            System.out.println("DELETE BEGIN");
            restTemplate.delete(url + "/{id}", plantation.getId());
            System.out.println("DELETE END");
        } else {
            System.out.println("Null object POST");
        }
    }
}
