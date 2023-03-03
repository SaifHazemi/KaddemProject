package tn.inetum.blm.kaddemproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inetum.blm.kaddemproject.Entities.Contrat;

import java.util.Date;
import java.util.List;


public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    List<Contrat> findByEtudiantDepartementUniversiteIdAndDateFinAndDateDebut
            (Long universiteId, Date dateDebut, Date dateFin);

    List<Contrat> findByArchiveFalseAndDateBetween(Date startDate, Date endDate);

}
