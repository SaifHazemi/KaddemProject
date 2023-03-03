package tn.inetum.blm.kaddemproject.Services.Contrat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.inetum.blm.kaddemproject.Entities.Contrat;
import tn.inetum.blm.kaddemproject.Entities.Etudiant;
import tn.inetum.blm.kaddemproject.Entities.Specialite;
import tn.inetum.blm.kaddemproject.Repository.ContratRepository;
import tn.inetum.blm.kaddemproject.Repository.EtudiantRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ContratService implements IContratService{

    private  final ContratRepository contratRepository;
    private  final EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.delete(retrieveContrat(idContrat));

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByNomAndPrenom(nomE,prenomE).orElse(null);
        if (etudiant == null || etudiant.getContrats().size() >= 5) {
            return null;
        }
        // Assign the contract to the student
        ce.setEtudiant(etudiant);
        etudiant.getContrats().add(ce);
        etudiantRepository.save(etudiant);
        return ce;
    }

    @Override
    public Map<Specialite, Float> getMontantContratEntreDeuxDate(Integer idUniv, Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findByEtudiantDepartementUniversiteIdAndDateFinAndDateDebut((long) idUniv, startDate, endDate);
        Map<Specialite, Float> montantContratParSpecialite = new HashMap<>();
        for (Contrat contrat : contrats) {
            Specialite specialite = contrat.getSpecialite();
            Float montantContrat = montantContratParSpecialite.get(specialite);
            if (montantContrat == null) {
                montantContrat = 0f;
            }
            montantContrat += contrat.getMontantContrat();
            montantContratParSpecialite.put(specialite, montantContrat);
        }
        return montantContratParSpecialite;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findByArchiveFalseAndDateBetween(startDate, endDate);
        return contrats.size();
    }
}
