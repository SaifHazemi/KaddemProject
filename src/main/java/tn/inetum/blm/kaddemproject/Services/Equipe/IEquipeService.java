package tn.inetum.blm.kaddemproject.Services.Equipe;

import tn.inetum.blm.kaddemproject.Entities.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe (Integer idEquipe);
    void faireEvoluerEquipes();


}
