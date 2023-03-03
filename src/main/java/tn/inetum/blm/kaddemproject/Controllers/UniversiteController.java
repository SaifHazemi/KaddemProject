package tn.inetum.blm.kaddemproject.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.inetum.blm.kaddemproject.Entities.Universite;
import tn.inetum.blm.kaddemproject.Services.Universite.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
@RequiredArgsConstructor
public class UniversiteController {
    //@Autowired
    private final IUniversiteService iUniversiteService;
    @GetMapping()
    public List<Universite> retrieveAllUniversite(){
        return (List<Universite>) iUniversiteService.retrieveAllUniversites();
    }
    @GetMapping("/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Integer universiteId) {
        return iUniversiteService.retrieveUniversite(universiteId);
    }
    @PostMapping()
    public Universite addUniversite(@RequestBody Universite u) {
       return iUniversiteService.addUniversite(u);
    }
    @PutMapping()
    public Universite updateUniversite(@RequestBody Universite u) {
        return iUniversiteService.updateUniversite(u);
    }

    @PostMapping("/{universite-id}/{departement-id}")
    public void assignUniversiteToDepartement(@PathVariable("universite-id") Integer universiteId,@PathVariable("departement-id") Integer departementId) {
        iUniversiteService.assignUniversiteToDepartement(universiteId,departementId);
    }
}
