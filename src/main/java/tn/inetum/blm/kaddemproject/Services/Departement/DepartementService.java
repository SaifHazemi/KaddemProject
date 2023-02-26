package tn.inetum.blm.kaddemproject.Services.Departement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.inetum.blm.kaddemproject.Entities.Departement;
import tn.inetum.blm.kaddemproject.Entities.Universite;
import tn.inetum.blm.kaddemproject.Repository.DepartementRepository;
import tn.inetum.blm.kaddemproject.Repository.UniversiteRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DepartementService implements IDepartementService{
private final DepartementRepository departementRepository;
private final UniversiteRepository universiteRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return (List<Departement>) departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return departementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if(universite == null){
            return null;
        }

        return universite.getDepartements();
    }
}
