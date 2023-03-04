package tn.inetum.blm.kaddemproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inetum.blm.kaddemproject.Entities.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{

    Optional<Etudiant> findEtudiantByNomEAndPrenomE(String nom, String prenom);

/*
    Etudiant findByNomEAndPrenomE(String nom,String prenom);
*/
}
