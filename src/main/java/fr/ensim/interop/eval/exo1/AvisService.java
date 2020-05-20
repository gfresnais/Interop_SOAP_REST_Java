package fr.ensim.interop.eval.exo1;

import fr.ensim.interop.eval.exo1.Model.Avis;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.*;

@WebService
public class AvisService {

	// TODO Exercice 1 - Implémentation d’un Web Service SOAP d’avis consommateur
    List<Avis> listAvis = new ArrayList<>();

    @WebMethod
    public int enregistrerAvis(@WebParam(name = "date") Date date,
                               @WebParam(name = "refProd") String refProd,
                               @WebParam(name = "note") int note,
                               @WebParam(name = "comm") String comm,
                               @WebParam(name = "pays") String pays,
                               @WebParam(name = "refFour") String refFour) {
        // 1. Journaliser l'appel
        System.out.println(">> enregistrerAvis : " + date + ", " + refProd + ", " + note + ", " + comm + ", " + pays + ", " + refFour);

        // 2. Valider les données en entrée
        if( refProd.length() > 20 ) throw new IllegalArgumentException("refProd : Longueur maximum de 20 caractères");
        if( !refProd.matches("[a-zA-Z0-9]+") ) throw new IllegalArgumentException("refProd : Doit contenir uniquement des caractères alphanumériques");

        if( note < 0 || note > 10 ) throw new IllegalArgumentException("note : Doit être entre 0 et 10 inclus");

        if( comm.length() > 300 ) throw new IllegalArgumentException("comm : Longueur maximum de 300 caractères");

        if( refFour.length() > 15 ) throw new IllegalArgumentException("refFour : Longueur maximum de 15 caractères");
        if( !refFour.matches("[a-zA-Z0-9]+") ) throw new IllegalArgumentException("refFour : Doit contenir uniquement des caractères alphanumériques");

        // 3. Simuler l'entregistrement de l'avis
        listAvis.add(new Avis(date, refProd, note, comm, pays, refFour));

        // 4. Fournir le nombre d'avis pour le fournisseur
        int nbAvis = 0;
        for (Avis avis: listAvis) {
            if(avis.getRefFournisseur().equals(refFour)) nbAvis++;
        }

        return nbAvis;
    }

    @WebMethod
    public List<Avis> listerAvis(@WebParam(name = "refProd") String refProd) {
        // 1. Journaliser l'appel
        System.out.println(">> listerAvis : " + refProd);

        // 2. Valider les données en entrée
        if( refProd.length() > 20 ) throw new IllegalArgumentException("refProd : Longueur maximum de 20 caractères");
        if( !refProd.matches("[a-zA-Z0-9]+") ) throw new IllegalArgumentException("refProd : Doit contenir uniquement des caractères alphanumériques");

        // 3.. Fournir la liste des avis pour le produit
        // non fait, liste triée
        List<Avis> avisProd = new ArrayList<>();
        for (Avis avis: listAvis) {
            if(avis.getRefProduit().equals(refProd)) avisProd.add(avis);
        }

        return avisProd;
    }
}