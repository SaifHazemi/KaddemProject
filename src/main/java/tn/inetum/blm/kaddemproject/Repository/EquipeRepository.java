package tn.inetum.blm.kaddemproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.inetum.blm.kaddemproject.Entities.Equipe;
import tn.inetum.blm.kaddemproject.Entities.Option;
import tn.inetum.blm.kaddemproject.Entities.Specialite;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    List<Equipe> findByEtudiantsOptionAndEtudiantsContratsSpecialite(Option op, Specialite sp);
}
