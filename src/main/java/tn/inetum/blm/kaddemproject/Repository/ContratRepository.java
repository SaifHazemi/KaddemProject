package tn.inetum.blm.kaddemproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.inetum.blm.kaddemproject.Entities.Contrat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat, Integer> {
/*
    List<Contrat> findByEtudiantDepartementUniversiteIdAndDateFinAndDateDebut
            (Long universiteId, Date dateDebut, Date dateFin);
*/


    @Query("select c from Contrat c where c.archive = false and c.dateDebutContrat > ?1 and c.dateFinContrat < ?2")
    List<Contrat> findByArchiveIsFalseAndDateDebutContratAfterAndAndDateFinContratBefore(Date startDate, Date endDate);


    @Query("select c from Contrat c where c.archive = false and c.dateFinContrat = ?1")
    List<Contrat> findByArchiveIsFalseAndDateFinContrat(LocalDate nowDate);
    @Query("select c from Contrat c where c.archive = false and c.dateFinContrat between ?1 and ?2")
    List<Contrat> findByArchiveIsFalseAndDateFinContratBetween(LocalDate nowDate , LocalDate datePlus15);



    @Query("""
            select c from Contrat c
            where c.archive = false and c.etudiant.departement.idDepart = ?1 and c.dateDebutContrat > ?2 and c.dateFinContrat < ?3
            order by c.specialite""")
    List<Contrat> findByArchiveIsFalseAndEtudiant_Departement_IdDepartAndDateDebutContratAfterAndAndDateFinContratBeforeOrderBySpecialite(int etudiant_departement_idDepart, Date datefin, Date datedebut);



    @Query("select count(c) from Contrat c where c.archive = false and c.etudiant.nomE = ?1 and c.etudiant.prenomE = ?2")
    Integer countContratByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nom,String prenom);

}
