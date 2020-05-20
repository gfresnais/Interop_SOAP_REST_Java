package fr.ensim.interop.eval.exo2.Controller;

import fr.ensim.interop.eval.exo2.Model.Plantation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class PlantationRestController {

	// TODO Exercice 2 - Implémentation d'une API REST pour la gestion de plantation

    private Map<Integer, Plantation> fakeDb = new HashMap<>();

    private AtomicInteger fakeSeq = new AtomicInteger(0);


    /**
     * Création d'une plantation en POST
     * @param parcelle
     * @param nomCommun
     * @param famille
     * @return
     */
    @PostMapping("/plantations")
    public ResponseEntity<Plantation> postPlantation(@RequestParam("parcelle") String parcelle,
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

        fakeDb.put(plantation.getId(), plantation);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(plantation.getId());

        return ResponseEntity.created(location).build();
    }

    /**
     * Ajoute une plantation
     * @param id
     * @param plantation
     * @return
     */
    @PutMapping("/plantations/{id}")
    public ResponseEntity<Plantation> ajouterPlantation(@PathVariable("id") @NotNull int id, @RequestBody @Valid Plantation plantation) {
        if(fakeDb.containsKey(id)) {
            plantation.setId(id);
            fakeDb.put(id, plantation);

            return ResponseEntity.ok().build();
        } else {
            plantation.setId(fakeSeq.incrementAndGet());
            fakeDb.put(plantation.getId(), plantation);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().build(plantation.getId());
            return ResponseEntity.created(location).build();
        }
    }

    /**
     * Supprimer une plantation
     * @param id
     * @return
     */
    @DeleteMapping("/plantations/{id}")
    public ResponseEntity<Plantation> supprimerPlantation(@PathVariable("id") @NotNull int id) {
        if(fakeDb.containsKey(id)) {
            fakeDb.remove(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Liste toutes les plantations
     * @return
     */
    @GetMapping("/plantations")
    public ResponseEntity<Collection<Plantation>> listerPlantation() {
        return ResponseEntity.ok().body(fakeDb.values());
    }
}