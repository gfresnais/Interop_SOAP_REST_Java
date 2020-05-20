package fr.ensim.interop.eval.exo2.Client;

import fr.ensim.interop.eval.exo2.Model.Plantation;
import org.springframework.web.client.RestTemplate;

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

        System.out.println("PUT BEGIN");
        restTemplate.put(url + "/{id}", plantation, plantation.getId());
        System.out.println("PUT END");

        plantation = restTemplate.getForObject(url + "/{id}", Plantation.class, plantation.getId());

        System.out.println("DELETE BEGIN");
        restTemplate.delete(url + "/{id}", plantation.getId());
        System.out.println("DELETE END");
    }
}
