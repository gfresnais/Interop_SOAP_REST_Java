package fr.ensim.interop.eval;

import fr.ensim.interop.eval.exo1.AvisService;
import javax.xml.ws.Endpoint;

public class AvisServiceRunner {
    public static void main(String[] args) {
        String url = "http://127.0.0.1:8889/AvisService";
        System.out.println("AvisService runner address : " + url);
        Endpoint.publish(url, new AvisService());
    }
}
