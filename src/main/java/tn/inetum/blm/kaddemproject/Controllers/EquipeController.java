package tn.inetum.blm.kaddemproject.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.inetum.blm.kaddemproject.Entities.Contrat;
import tn.inetum.blm.kaddemproject.Entities.Equipe;
import tn.inetum.blm.kaddemproject.Services.Equipe.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/equipe")
@RequiredArgsConstructor
public class EquipeController {
    //@Autowired
    private final IEquipeService iEquipeService;
    @GetMapping()
    public List<Equipe> retrieveAllEquipes(){
        return (List<Equipe>) iEquipeService.retrieveAllEquipes();
    }
    @GetMapping("/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") Integer equipeId) {
        return iEquipeService.retrieveEquipe(equipeId);
    }
    @PostMapping()
    public Equipe addEquipe(@RequestBody Equipe e) {
       return iEquipeService.addEquipe(e);
    }
    @PutMapping()
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return iEquipeService.updateEquipe(e);
    }
}
