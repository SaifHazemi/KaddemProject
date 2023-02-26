package tn.inetum.blm.kaddemproject.Services.Departement;

import tn.inetum.blm.kaddemproject.Entities.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement d);

    Departement updateDepartement (Departement d);

    Departement retrieveDepartement (Integer idDepart);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
