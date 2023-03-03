package tn.inetum.blm.kaddemproject.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.inetum.blm.kaddemproject.Entities.Departement;
import tn.inetum.blm.kaddemproject.Services.Departement.IDepartementService;

import java.util.List;


@RestController
@RequestMapping("/departement")
@RequiredArgsConstructor
public class DepartementController {
    //@Autowired
    private final IDepartementService iDepartementService;
    @GetMapping()
    public List<Departement> retrieveAllDepartements() {
        List<Departement> listDepartements = iDepartementService.retrieveAllDepartements();
        return listDepartements;
    }
    @GetMapping("/{departement-id}")
    public Departement retrieveDepartement(@PathVariable("departement-id") Integer departementId) {
        return iDepartementService.retrieveDepartement(departementId);
    }
    @PostMapping()
    public void addDepartement(@RequestBody Departement de) {
         iDepartementService.addDepartement(de);
    }
    @PutMapping()
    public Departement updateDepartement(@RequestBody Departement de) {
        return iDepartementService.updateDepartement(de);
    }
    @GetMapping("/{universite-id}")
    public List<Departement> retrieveDepartementsByUniversite(@PathVariable("universite-id") Integer idUniversite) {
        return iDepartementService.retrieveDepartementsByUniversite(idUniversite);
    }
}
