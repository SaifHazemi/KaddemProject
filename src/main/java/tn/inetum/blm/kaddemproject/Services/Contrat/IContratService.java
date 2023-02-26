package tn.inetum.blm.kaddemproject.Services.Contrat;

import tn.inetum.blm.kaddemproject.Entities.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);
    Contrat affectContratToEtudiant (Contrat ce,String nomE,String prenomE);
}
