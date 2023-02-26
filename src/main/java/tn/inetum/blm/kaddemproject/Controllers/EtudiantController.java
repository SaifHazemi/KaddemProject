package tn.inetum.blm.kaddemproject.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.inetum.blm.kaddemproject.Entities.Etudiant;
import tn.inetum.blm.kaddemproject.Services.Etudiant.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantController  {
    //@Autowired
    private final IEtudiantService iEtudiantService;

    @GetMapping()
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> listEtudiants = iEtudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    @GetMapping("/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
        return iEtudiantService.retrieveEtudiant(etudiantId);
    }
    @PostMapping()
    public void addEtudiant(@RequestBody Etudiant e) {
        // Etudiant etudiant = iEtudiantService.addEtudiant(e);
         iEtudiantService.addEtudiant(e);
    }
    @DeleteMapping("/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
        iEtudiantService.removeEtudiant(etudiantId);
    }
    @PutMapping()
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantService.updateEtudiant(e);
    }
}
