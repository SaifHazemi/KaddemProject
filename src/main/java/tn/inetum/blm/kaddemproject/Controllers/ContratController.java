package tn.inetum.blm.kaddemproject.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.inetum.blm.kaddemproject.Entities.Contrat;
import tn.inetum.blm.kaddemproject.Entities.Specialite;
import tn.inetum.blm.kaddemproject.Services.Contrat.IContratService;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/contrat")
@RequiredArgsConstructor
public class ContratController {
    //@Autowired
    private final IContratService iContratService;
    @GetMapping()
    public List<Contrat> retrieveAllContrats (){
        return iContratService.retrieveAllContrats();
    }
    @GetMapping("/{contrat-id}")
    public Contrat retrieveContart(@PathVariable("contart-id") Integer contartId) {
        return iContratService.retrieveContrat(contartId);
    }
    @PostMapping()
    public void addContart(@RequestBody Contrat ce) {
         iContratService.addContrat(ce);
    }
    @DeleteMapping("/{contart-id}")
    public void removeContart(@PathVariable("contart-id") Integer contartId) {
        iContratService.removeContrat(contartId);
    }
    @PutMapping()
    public Contrat updateContart(@RequestBody Contrat ce) {

        return iContratService.updateContrat(ce);
    }
    @PutMapping("/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable("nomE") String nom , @PathVariable("prenomE") String prenom) {
        return iContratService.affectContratToEtudiant(ce ,nom ,prenom);
    }

/*    @GetMapping("/{universite-id}/{startDate}/{endDate}")
    public Map<Specialite, Float> affectContratToEtudiant(@PathVariable("universite-id") Integer universiteId, @PathVariable("startDate") Date startDate , @PathVariable("endDate") Date endDate) {
        return iContratService.getMontantContratEntreDeuxDate(universiteId,startDate ,endDate);
    }*/

/*    @GetMapping("/{startDate}/{endDate}")
    public Integer affectContratToEtudiant(@PathVariable("startDate") Date startDate , @PathVariable("endDate") Date endDate) {
        return iContratService.nbContratsValides(startDate ,endDate);
    }*/
}
