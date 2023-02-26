package tn.inetum.blm.kaddemproject.Services.Universite;

import tn.inetum.blm.kaddemproject.Entities.Universite;
import tn.inetum.blm.kaddemproject.Repository.DepartementRepository;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
