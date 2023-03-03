package tn.inetum.blm.kaddemproject.Services.Contrat;

import tn.inetum.blm.kaddemproject.Entities.Contrat;
import tn.inetum.blm.kaddemproject.Entities.Specialite;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant (Contrat ce,String nomE,String prenomE);
    Map<Specialite, Float> getMontantContratEntreDeuxDate(Integer idUniv, Date startDate, Date endDate);

    Integer nbContratsValides(Date startDate, Date endDate);
}
