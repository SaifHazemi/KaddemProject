package tn.inetum.blm.kaddemproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inetum.blm.kaddemproject.Entities.Contrat;
import tn.inetum.blm.kaddemproject.Entities.Departement;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
