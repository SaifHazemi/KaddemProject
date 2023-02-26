package tn.inetum.blm.kaddemproject.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.inetum.blm.kaddemproject.Entities.Contrat;
import tn.inetum.blm.kaddemproject.Services.Contrat.IContratService;

import java.util.List;


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
}
