import fr.ensim.interop.eval.exo1.Model.Avis;
import fr.ensim.interop.eval.exo1.AvisService;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class AvisServiceTest {
    @Test
    public void testListerEnregistrerAvis() {
        AvisService avisService = new AvisService();

        List<Avis> avisList = avisService.listerAvis("PROD123");
        assertEquals(0, avisList.size());

        int nbAvis = avisService.enregistrerAvis(Calendar.getInstance(Locale.FRANCE).getTime(),
                "PROD123", 5, "Bonjour c'est génial", "FR", "FOUR123");
        assertEquals(1, nbAvis);

        avisList = avisService.listerAvis("PROD123");
        assertEquals(1, avisList.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionLongueurRefProduitLister() {
        AvisService avisService = new AvisService();
        List<Avis> avisList = avisService.listerAvis("PROD123gvbozhgoeizgmpheziugzigez");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionCaracteresRefProduitLister() {
        AvisService avisService = new AvisService();
        List<Avis> avisList = avisService.listerAvis("PROD-123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionLongueurRefProduitEnregistrer() {
        AvisService avisService = new AvisService();
        avisService.enregistrerAvis(Calendar.getInstance(Locale.FRANCE).getTime(),
                "PROD123greogrjoehopreshiurespheisuh", 5, "Bonjour c'est génial", "FR", "FOUR123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionCaracteresRefProduitEnregistrer() {
        AvisService avisService = new AvisService();
        avisService.enregistrerAvis(Calendar.getInstance(Locale.FRANCE).getTime(),
                "PROD-123", 5, "Bonjour c'est génial", "FR", "FOUR123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionNoteNegativeEnregistrer() {
        AvisService avisService = new AvisService();
        avisService.enregistrerAvis(Calendar.getInstance(Locale.FRANCE).getTime(),
                "PROD123", -1, "Bonjour c'est génial", "FR", "FOUR123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionNoteSuperieurEnregistrer() {
        AvisService avisService = new AvisService();
        avisService.enregistrerAvis(Calendar.getInstance(Locale.FRANCE).getTime(),
                "PROD123", 11, "Bonjour c'est génial", "FR", "FOUR123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionLongueurCommentaireEnregistrer() {
        AvisService avisService = new AvisService();
        avisService.enregistrerAvis(Calendar.getInstance(Locale.FRANCE).getTime(),
                "PROD123", 5,
                "Bonjour c'est génial aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "FR", "FOUR123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionLongueurRefFournisseurEnregistrer() {
        AvisService avisService = new AvisService();
        avisService.enregistrerAvis(Calendar.getInstance(Locale.FRANCE).getTime(),
                "PROD123", 5, "Bonjour c'est génial", "FR",
                "FOUR123gnozgezhogiehgouiepghreiougpheigre");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionCaracteresRefFournisseurEnregistrer() {
        AvisService avisService = new AvisService();
        avisService.enregistrerAvis(Calendar.getInstance(Locale.FRANCE).getTime(),
                "PROD123", 5, "Bonjour c'est génial", "FR",
                "FOUR-123");
    }
}
