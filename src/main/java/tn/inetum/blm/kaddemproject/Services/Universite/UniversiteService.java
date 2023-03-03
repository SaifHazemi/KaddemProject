package tn.inetum.blm.kaddemproject.Services.Universite;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.inetum.blm.kaddemproject.Entities.Departement;
import tn.inetum.blm.kaddemproject.Entities.Universite;
import tn.inetum.blm.kaddemproject.Repository.DepartementRepository;
import tn.inetum.blm.kaddemproject.Repository.UniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteService  implements IUniversiteService{

    private final UniversiteRepository universiteRepository;
    private final DepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        Assert.isNull(universite,"The university is null ");
        Assert.isNull(departement,"The departement is null ");
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);
    }
}
