package tn.inetum.blm.kaddemproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.inetum.blm.kaddemproject.Entities.Contrat;

import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat, Integer> {
/*
    List<Contrat> findByEtudiantDepartementUniversiteIdAndDateFinAndDateDebut
            (Long universiteId, Date dateDebut, Date dateFin);
*/

/*
    List<Contrat> findByArchiveFalseAndDateBetween(Date startDate, Date endDate);
*/




    @Query("""
            select c from Contrat c
            where c.archive = false and c.etudiant.departement.idDepart = ?1 and c.dateDebutContrat between ?2 and ?3 and c.dateFinContrat between ?2 and ?3
            order by c.specialite""")
    List<Contrat> findByArchiveIsFalseAndEtudiant_Departement_IdDepartAndDateDebutContratBetweenAndAndDateFinContratBetweenOrderBySpecialite(int etudiant_departement_idDepart,Date datedebut,Date datefin);



    @Query("select count(c) from Contrat c where c.archive = false and c.etudiant.nomE = ?1 and c.etudiant.prenomE = ?2")
    Integer countContratByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nom,String prenom);

}
